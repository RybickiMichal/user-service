package com.mprybicki.userservice.model;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
@Getter
public class User {

    @Id
    private String id;

    @Length(min = 5)
    @NotBlank
    private String userName;

    @Length(min = 5)
    @NotBlank
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
