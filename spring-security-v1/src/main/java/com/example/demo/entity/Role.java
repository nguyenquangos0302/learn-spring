package com.example.demo.entity;

import com.example.demo.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table( name = "role",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends Abstract {

    @Enumerated(EnumType.STRING)
    private ERole name;

}
