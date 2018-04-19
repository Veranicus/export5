package com.tieto.export.security;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user;


    @Before
public void setup(){
        user = new User("testUsername");
    }

    @Test
    public void getUsername() {
        assertEquals("testUsername", user.getUsername());
    }

    @Test
    public void setUsername() {
        user.setUsername("John");
        assertEquals("John", user.getUsername());
    }

    @Test
    public void getPassword() {
        user.setPassword("testPassword");
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    public void setPassword() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void getAuthorities() {
    }

    @Test
    public void getCredentials() {
    }

    @Test
    public void getDetails() {
    }

    @Test
    public void getPrincipal() {
    }

    @Test
    public void isAuthenticated() {
    }

    @Test
    public void setAuthenticated() {
    }

    @Test
    public void getRoles() {
    }

    @Test
    public void setRoles() {
    }
}