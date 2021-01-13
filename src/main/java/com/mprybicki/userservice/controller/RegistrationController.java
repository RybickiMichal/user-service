package com.mprybicki.userservice.controller;

import com.mprybicki.userservice.model.User;
import com.mprybicki.userservice.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
public class RegistrationController {

    RegistrationService registrationService;

    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody User user) {
        registrationService.registerUser(user);
    }
}
