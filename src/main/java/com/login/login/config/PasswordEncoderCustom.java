package com.login.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderCustom implements PasswordEncoder {

    public PasswordEncoderCustom() {}

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(rawPassword.toString());
    }
}
