package com.example.security.config.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LogManager.getLogger(SecurityConfig.class.getName());

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info("==================== START SECURITY CONFIG PROCESS ===================");
        LOGGER.warn(">>>>> [configure] --> EXECUTE PROCESS");
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/v1/registration", "/api/v1/confirm").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
        LOGGER.warn("[configure] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END SECURITY CONFIG PROCESS ===================");
    }

}
