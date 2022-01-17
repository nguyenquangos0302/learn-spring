package com.example.security.config.mapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    private static final Logger LOGGER = LogManager.getLogger(ModelMapperConfig.class.getName());

    @Bean
    public ModelMapper modelMapper() {
        LOGGER.info("==================== START MODEL MAPPER CONFIG PROCESS ===================");
        LOGGER.warn(">>>>> [modelMapper] --> EXECUTE PROCESS");
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        LOGGER.warn("[modelMapper] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END MODEL MAPPER CONFIG PROCESS ===================");
        return modelMapper;
    }

}
