package com.example.security.config.freemarker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@Configuration
public class FreeMarkerConfig {

    private static final Logger LOGGER = LogManager.getLogger(FreeMarkerConfig.class.getName());

    @Bean(name = "freeMarkerCustomerApp")
    public FreeMarkerConfigurationFactoryBean factoryBean() {
        LOGGER.info("==================== START FREEMARKER CONFIG PROCESS ===================");
        LOGGER.warn(">>>>> [factoryBean] --> EXECUTE PROCESS");
        FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPath("classpath:/templates");
        LOGGER.warn("[factoryBean] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END FREEMARKER CONFIG PROCESS ===================");
        return bean;
    }

}
