package com.tieto.export.data.structure;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AurEntityWithRolesDtoTest {


    private AurEntityWithRolesDto aurEntityWithRolesDto;

    @Before
    public void setup() {
        aurEntityWithRolesDto = new AurEntityWithRolesDto();
    }

    @Test
    public void getUserRoles() {

        List<String> testUserRoles = new ArrayList<>();
        String testRole = "testRole";
        testUserRoles.add(testRole);
        aurEntityWithRolesDto.setUserRoles(testUserRoles);
        assertEquals("testRole", aurEntityWithRolesDto.getUserRoles().get(0));
    }

    @Test
    public void setUserRoles() {
        List<String> testUserRoles = new ArrayList<>();
        String testRole = "testRole";
        testUserRoles.add(testRole);
        aurEntityWithRolesDto.setUserRoles(testUserRoles);
        assertEquals("testRole", aurEntityWithRolesDto.getUserRoles().get(0));
    }

    @Test
    public void getEntname() {
        aurEntityWithRolesDto.setEntname("testEntname");
        assertEquals("testEntname", aurEntityWithRolesDto.getEntname());
    }

    @Test
    public void setEntname() {
        aurEntityWithRolesDto.setEntname("testEntname");
        assertEquals("testEntname", aurEntityWithRolesDto.getEntname());
    }
}