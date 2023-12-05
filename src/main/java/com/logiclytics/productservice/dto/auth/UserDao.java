package com.logiclytics.productservice.dto.auth;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {
    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "bovali.social@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE ADMIN"))
            ),
            new User(
                    "test.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE USER"))
            )
    );

    public UserDetails findUserByEmail(String email) {
        return APPLICATION_USERS
                .stream()
                .filter(userDetails -> userDetails.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("no user was found"));
    }
}
