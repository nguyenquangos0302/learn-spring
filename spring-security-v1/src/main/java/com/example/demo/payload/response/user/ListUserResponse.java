package com.example.demo.payload.response.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListUserResponse implements Serializable {

    private UUID id;

    private String name;

    private String userName;

    private String email;

}
