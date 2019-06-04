package com.jaletechs.png.controllers.util;

import com.jaletechs.png.dtos.UserDto;
import com.jaletechs.png.entities.security.User;

/**
 * Created by jaletechs on 2019-06-02.
 */
public class EntityMapper {
    public static UserDto mapToUserDto(User user) {
        if (user == null) {
            return null;
        }

        UserDto dto = new UserDto();
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setEnabled(user.isEnabled());
        dto.setLastPasswordResetDate(user.getLastPasswordResetDate());

        return dto;
    }
} 
