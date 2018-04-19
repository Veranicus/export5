package com.tieto.export.data.structure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GlobalRoleDtoTest {

    private GlobalRoleDto globalRoleDto;

    @Before
    public void setup() {
        globalRoleDto = new GlobalRoleDto();
    }


    @Test
    public void getId() {
        globalRoleDto.setId(5456434L);
        assertEquals(5456434L, globalRoleDto.getId());
    }

    @Test
    public void setId() {
        globalRoleDto.setId(5456434L);
        assertEquals(5456434L, globalRoleDto.getId());
    }

    @Test
    public void getTitle() {
        globalRoleDto.setTitle("testTitle");
        assertEquals("testTitle", globalRoleDto.getTitle());
    }

    @Test
    public void setTitle() {
        globalRoleDto.setTitle("testTitle");
        assertEquals("testTitle", globalRoleDto.getTitle());
    }

    @Test
    public void isDefaultRole() {
        globalRoleDto.setDefaultRole(false);
        assertFalse(globalRoleDto.isDefaultRole());
    }

    @Test
    public void setDefaultRole() {
        globalRoleDto.setDefaultRole(false);
        assertFalse(globalRoleDto.isDefaultRole());
    }

    @Test
    public void isEditable() {
        globalRoleDto.setEditable(false);
        assertFalse(globalRoleDto.isEditable());
    }

    @Test
    public void setEditable() {
        globalRoleDto.setEditable(false);
        assertFalse(globalRoleDto.isEditable());
    }

    @Test
    public void getAlternatekey() {
        globalRoleDto.setAlternatekey("testAlternatekey");
        assertEquals("testAlternatekey", globalRoleDto.getAlternatekey());
    }

    @Test
    public void setAlternatekey() {
        globalRoleDto.setAlternatekey("testAlternatekey");
        assertEquals("testAlternatekey", globalRoleDto.getAlternatekey());
    }
}