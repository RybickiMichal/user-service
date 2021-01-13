package com.mprybicki.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthenticateRequest {

    private String userName;
    private String password;
}
