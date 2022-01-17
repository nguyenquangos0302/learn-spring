package com.example.security.config.password;

import com.example.security.config.mapper.ModelMapperConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    private static final Logger LOGGER = LogManager.getLogger(PasswordConfig.class.getName());

    @Bean
    public PasswordEncoder passwordEncoder() {
        LOGGER.info("==================== START PASSWORD CONFIG PROCESS ===================");
        LOGGER.warn(">>>>> [passwordEncoder] --> EXECUTE PROCESS");
        LOGGER.warn("[passwordEncoder] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END PASSWORD CONFIG PROCESS ===================");
        return new BCryptPasswordEncoder(10);
    }

}
