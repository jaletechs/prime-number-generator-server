package com.jaletechs.png.managers;

import com.jaletechs.png.entities.security.User;
import com.jaletechs.png.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jaletechs on 2019-06-01.
 */
@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String email) {
        return userRepository.getByEmail(email);
    }
}
