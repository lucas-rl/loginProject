package com.login.login.usecase;

import com.login.login.gateway.model.RoleModel;
import com.login.login.gateway.model.UserModel;
import com.login.login.gateway.repository.UserRepository;
import com.login.login.usecase.data.UserRegistration;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class LoginUseCase {
    UserRepository repository;

    LoginUseCase(UserRepository userRepository){
        this.repository = userRepository;
    }

    public UserModel register(UserRegistration userRegistration){
        UserModel user = new UserModel(
                userRegistration.getFirstName(),
                userRegistration.getLastName(),
                birthDate(userRegistration.getBirthDate()),
                userRegistration.getEmail(),
                userRegistration.getPassword(),
                List.of(new RoleModel("ROLE_USER"))
        );

        return repository.save(user);

    }

    private LocalDate birthDate(String day){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(day, formatter);
    }

}
