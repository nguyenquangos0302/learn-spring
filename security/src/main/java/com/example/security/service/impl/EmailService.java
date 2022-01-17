package com.example.security.service.impl;

import com.example.security.constant.EmailConstant;
import com.example.security.constant.MessageConstant;
import com.example.security.exception.message.SendMailExceptionMessage;
import com.example.security.exception.message.SystemExceptionMessage;
import com.example.security.exception.message.TemplateEmailNotFoundExceptionMessage;
import com.example.security.service.IEmailService;
import com.example.security.utils.EmailUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class EmailService implements IEmailService {

    private static final Logger LOGGER = LogManager.getLogger(EmailUtil.class.getName());

    private JavaMailSender mailSender;

    private Configuration emailConfigure;

    public EmailService(@Qualifier("freeMarkerCustomerApp") Configuration emailConfigure, JavaMailSender mailSender) {
        this.emailConfigure = emailConfigure;
        this.mailSender = mailSender;
    }

    @Override
    @Async("emailTaskExecutor")
    public void sendEmail(String email, Map<String, Object> model, String subject) {
        LOGGER.info("==================== START EMAIL SERVICE PROCESS ===================");
        LOGGER.warn(">>>>> [sendEmail] --> EXECUTE PROCESS");
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            Template t = emailConfigure
                    .getTemplate("email-template.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

            helper.setFrom(EmailConstant.EMAIL_FROM);
            helper.setTo(email);
            helper.setText(html, true);
            helper.setSubject(subject);
            mailSender.send(mimeMessage);
            LOGGER.warn("[sendEmail] --> FINISH PROCESS <<<<<");
            LOGGER.info("==================== END EMAIL SERVICE PROCESS ===================");
        } catch (TemplateNotFoundException e) {
            LOGGER.error(">>>>> REASON sendEmail EXECUTE FAIL: " + e.getMessage() + " <<<<<");
            throw new TemplateEmailNotFoundExceptionMessage(MessageConstant.SYSTEM_ERROR);
        } catch (MailSendException | SendFailedException e) {
            LOGGER.error(">>>>> REASON sendEmail EXECUTE FAIL: " + e.getMessage() + " <<<<<");
            throw new SendMailExceptionMessage(MessageConstant.EMAIL_ERROR);
        } catch (Exception e) {
            LOGGER.error(">>>>> REASON sendEmail EXECUTE FAIL: " + e.getMessage() + " <<<<<");
            throw new SystemExceptionMessage(e.getMessage());
        }

    }
}
