package com.example.security.config.generateid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class GenerateUUIDConfig implements IdentifierGenerator {

    private static final Logger LOGGER = LogManager.getLogger(GenerateUUIDConfig.class.getName());

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        LOGGER.info("==================== START GENERATE UUID PROCESS ===================");
        LOGGER.warn(">>>>> [generate] --> EXECUTE PROCESS");
        UUID uuid = UUID.randomUUID();
        LOGGER.info("UUID: " + uuid.toString());
        LOGGER.warn("[generate] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END GENERATE UUID PROCESS ===================");
        return uuid.toString();
    }

    @Override
    public boolean supportsJdbcBatchInserts() {
        return IdentifierGenerator.super.supportsJdbcBatchInserts();
    }
}
