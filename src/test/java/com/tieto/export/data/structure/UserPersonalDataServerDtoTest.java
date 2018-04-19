package com.tieto.export.data.structure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserPersonalDataServerDtoTest {

    private UserPersonalDataServerDto userPersonalDataServerDto;

    @Before
    public void setup() {
        userPersonalDataServerDto = new UserPersonalDataServerDto();
    }

    @Test
    public void getServerId() {
        userPersonalDataServerDto.setServerId("testServerId");
        assertEquals("testServerId", userPersonalDataServerDto.getServerId());
    }

    @Test
    public void setServerId() {
        userPersonalDataServerDto.setServerId("testServerId");
        assertEquals("testServerId", userPersonalDataServerDto.getServerId());
    }

    @Test
    public void getFqdn() {
        userPersonalDataServerDto.setFqdn("testFqdn");
        assertEquals("testFqdn", userPersonalDataServerDto.getFqdn());
    }

    @Test
    public void setFqdn() {
        userPersonalDataServerDto.setFqdn("testFqdn");
        assertEquals("testFqdn", userPersonalDataServerDto.getFqdn());
    }

    @Test
    public void getName() {
        userPersonalDataServerDto.setName("testName");
        assertEquals("testName", userPersonalDataServerDto.getName());
    }

    @Test
    public void setName() {
        userPersonalDataServerDto.setName("testName");
        assertEquals("testName", userPersonalDataServerDto.getName());
    }

    @Test
    public void getAuthentication() {
        userPersonalDataServerDto.setAuthentication("testAuthentication");
        assertEquals("testAuthentication", userPersonalDataServerDto.getAuthentication());

    }

    @Test
    public void setAuthentication() {
        userPersonalDataServerDto.setAuthentication("testAuthentication");
        assertEquals("testAuthentication", userPersonalDataServerDto.getAuthentication());
    }
}