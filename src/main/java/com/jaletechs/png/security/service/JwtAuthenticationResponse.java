package com.jaletechs.png.security.service;

import java.io.Serializable;

/**
 * Created by jaletechs on 2019-06-01.
 */
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;

    public JwtAuthenticationResponse() {

    }

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
