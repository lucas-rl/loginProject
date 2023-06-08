package com.login.login.usecase;

import com.login.login.gateway.model.UserModel;
import com.login.login.gateway.repository.RoleRepository;
import com.login.login.gateway.repository.UserRepository;
import com.login.login.usecase.data.UserRegistration;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class LoginUseCase {
    UserRepository repository;
    RoleRepository roleRepository;

    LoginUseCase(UserRepository userRepository, RoleRepository roleRepository){
        this.repository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserModel register(UserRegistration userRegistration){
        UserModel user = new UserModel(
                userRegistration.getFirstName(),
                userRegistration.getLastName(),
                birthDate(userRegistration.getBirthDate()),
                userRegistration.getEmail(),
                userRegistration.getPassword(),
                List.of(roleRepository.findByName("ROLE_USER"))
        );

        return repository.save(user);

    }

    private LocalDate birthDate(String day){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(day, formatter);
    }

}
