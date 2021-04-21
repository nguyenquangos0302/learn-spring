package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Abstract implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private String id;

    @Column(name = "createddate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column(name = "modifieddate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date modifiedDate;

    @Column(name = "createdby", columnDefinition = "VARCHAR(255) DEFAULT 'system'")
    private String createdBy;

    @Column(name = "modifiedby", columnDefinition = "VARCHAR(255) DEFAULT 'system'")
    private String modifiedBy;

}
