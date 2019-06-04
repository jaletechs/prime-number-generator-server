package com.jaletechs.png.managers;

import com.jaletechs.png.entities.security.User;

/**
 * Created by jaletechs on 2019-06-01.
 */
public interface UserManager {

    User saveUser(User user);

    User getUser(String email);
}
