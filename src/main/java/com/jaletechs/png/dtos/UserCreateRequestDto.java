package com.jaletechs.png.dtos;

/**
 * Created by jaletechs on 2/25/19.
 */
public class UserCreateRequestDto {

    private String email;
    private String password;
    private String fullName;

    public UserCreateRequestDto () {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
