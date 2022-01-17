package com.example.security.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "phone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Phone extends Base {

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "region", nullable = false)
    private String region;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
