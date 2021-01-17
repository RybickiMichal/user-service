package com.mprybicki.userservice.service;

import com.mprybicki.userservice.exception.UserException;
import com.mprybicki.userservice.model.User;
import com.mprybicki.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@AllArgsConstructor
@Service
public class UserValidationService {

    UserRepository userRepository;

    public void validateUser(@Valid User user) {
        if(userRepository.existsByUserName(user.getUserName())){
            throw new UserException("User with email " + user.getUserName() + " already exists");
        }
    }
}
