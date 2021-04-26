package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Basic implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", nullable = false)
    private String id;

    @Column(name = "createddate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private Date createdDate;

    @Column(name = "modifieddate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private Date modifiedDate;

    @Column(name = "createdby", columnDefinition = "VARCHAR(255) DEFAULT 'system'", nullable = false)
    private String createdBy;

    @Column(name = "modifiedby", columnDefinition = "VARCHAR(255) DEFAULT 'system'", nullable = false)
    private String modifiedBy;

    @PrePersist
    protected void onCreate() {
        if (createdDate == null) {
            createdDate = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        }
        if (modifiedDate == null) {
            modifiedDate = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        }
        if (createdBy == null) {
            createdBy = "SYSTEM";
        }
        if (modifiedBy == null) {
            modifiedBy = "SYSTEM";
        }
    }
}
