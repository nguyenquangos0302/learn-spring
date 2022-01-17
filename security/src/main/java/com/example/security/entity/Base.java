package com.example.security.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Base {

    private static final Logger LOGGER = LogManager.getLogger(Base.class.getName());

    @Id
    @GenericGenerator(name = "id", strategy = "com.example.security.config.generateid.GenerateUUIDConfig")
    @GeneratedValue(generator = "id")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", nullable = false)
    private String id;

    @CreatedBy
    @Column(name = "createddate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private LocalDateTime createdDate;

    @CreatedDate
    @Column(name = "createdby", columnDefinition = "VARCHAR(255)", nullable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "lastmidifiedby", columnDefinition = "VARCHAR(255)", nullable = false)
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "lastmodifieddate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private LocalDateTime lastModifiedDate;

    @PrePersist
    protected void onCreate() {
        LOGGER.info("==================== START BASE PROCESS ===================");
        LOGGER.warn(">>>>> [onCreate] --> EXECUTE PROCESS");
        if (createdDate == null) {
            createdDate = LocalDateTime.now();
        }
        if (lastModifiedDate == null) {
            lastModifiedDate = LocalDateTime.now();
        }
        if (createdBy == null) {
            createdBy = "SYSTEM";
        }
        if (lastModifiedBy == null) {
            lastModifiedBy = "SYSTEM";
        }
        LOGGER.info("CREATEDBY: " + createdBy + ", CREATEDDATE: " + createdDate + ", LASTMODIFIEDBY: " + lastModifiedBy + ", LASTMODIFIEDDATE: " + lastModifiedDate);
        LOGGER.warn("[onCreate] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END BASE PROCESS ===================");
    }

}
