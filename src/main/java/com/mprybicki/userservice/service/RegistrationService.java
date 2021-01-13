package com.mprybicki.userservice.service;

import com.mprybicki.userservice.model.User;
import com.mprybicki.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistrationService {

    UserRepository userRepository;

    public void registerUser(User user) {
    userRepository.save(user);
    }
}
