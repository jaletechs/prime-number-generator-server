package com.jaletechs.png.controllers;

import com.jaletechs.png.controllers.util.ApiPaths;
import com.jaletechs.png.dtos.UserCreateRequestDto;
import com.jaletechs.png.entities.security.Authority;
import com.jaletechs.png.entities.security.User;
import com.jaletechs.png.managers.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jaletechs.png.controllers.util.EntityMapper.mapToUserDto;

/**
 * Created by jaletechs on 2019-06-01.
 */
@RestController
@RequestMapping(ApiPaths.AUTH + ApiPaths.USERS)
public class UserRestController {

    @Autowired
    private UserManager userManager;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody UserCreateRequestDto request) {

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(new BCryptPasswordEncoder()
                .encode(request.getPassword()));
        user.setEnabled(true);
        user.setLastPasswordResetDate(new Date());
        user.setFullName(request.getFullName());

        user = userManager.saveUser(user);

        List<Authority> authorities = new ArrayList<>();
        List<User> users = new ArrayList<>();
        users.add(user);
        Authority authority = Authority.getUserRole();
        authority.setUsers(users);
        authorities.add(authority);
        user.setAuthorities(authorities);

        return new ResponseEntity<>(mapToUserDto(userManager.saveUser(user)), HttpStatus.CREATED);
    }
} 
