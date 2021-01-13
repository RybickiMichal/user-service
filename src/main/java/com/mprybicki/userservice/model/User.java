package com.mprybicki.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Document
@Getter
public class User {

    @Id
    private String id;
    private String userName;
    private String password;
}
