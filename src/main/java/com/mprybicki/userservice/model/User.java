package com.mprybicki.userservice.model;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Document
@Getter
public class User {

    @Id
    private String id;

    @Email
    @Length(min = 5)
    @NotBlank
    private String userName;

    @Length(min = 5)
    @NotBlank
    private String password;

    private List<String> roles;

    public User(String userName, String password, List<String> roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }
}
