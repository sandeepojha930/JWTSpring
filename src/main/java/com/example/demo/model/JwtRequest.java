package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtRequest implements Serializable {
    private static final long serialVersionID = 5926468583005150707L;
    private String username;
    private String password;

    public JwtRequest() {

    }

    public JwtRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
