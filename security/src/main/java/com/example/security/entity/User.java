package com.example.security.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User extends Base {

    private static final Logger LOGGER = LogManager.getLogger(User.class.getName());

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Phone> phones;

    @OneToMany(mappedBy = "userConfirm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ConfirmUser> confirms;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public void addPhoneNumber(Phone phoneNumber) {
        LOGGER.info("==================== START USER PROCESS ===================");
        LOGGER.warn(">>>>> [addPhoneNumber] --> EXECUTE PROCESS");
        if (phoneNumber != null) {
            if (this.phones == null) {
                this.phones = new HashSet<>();
            }
            phoneNumber.setUser(this);
            phones.add(phoneNumber);
        }
        LOGGER.warn("[addPhoneNumber] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END USER PROCESS ===================");
    }

    public void addConfirm(ConfirmUser confirmUser) {
        LOGGER.info("==================== START USER PROCESS ===================");
        LOGGER.warn(">>>>> [addConfirm] --> EXECUTE PROCESS");
        if (confirmUser != null) {
            if (this.confirms == null) {
                this.confirms = new HashSet<>();
            }
            confirmUser.setUserConfirm(this);
            confirms.add(confirmUser);
        }
        LOGGER.warn("[addConfirm] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END USER PROCESS ===================");
    }

}
