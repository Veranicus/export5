package com.tieto.export.data.structure;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserPersonalDataProductSpaceDtoTest {

private UserPersonalDataProductSpaceDto userPersonalDataProductSpaceDto;


    @Before
    public void setup() {
        userPersonalDataProductSpaceDto = new UserPersonalDataProductSpaceDto();
    }


    @Test
    public void getProductId() {
        userPersonalDataProductSpaceDto.setProductId("testProductId");
        assertEquals("testProductId", userPersonalDataProductSpaceDto.getProductId());
    }

    @Test
    public void setProductId() {
        userPersonalDataProductSpaceDto.setProductId("testProductId");
        assertEquals("testProductId", userPersonalDataProductSpaceDto.getProductId());
    }

    @Test
    public void getName() {
        userPersonalDataProductSpaceDto.setName("testName");
        assertEquals("testName", userPersonalDataProductSpaceDto.getName());
    }

    @Test
    public void setName() {
        userPersonalDataProductSpaceDto.setName("testName");
        assertEquals("testName", userPersonalDataProductSpaceDto.getName());
    }

    @Test
    public void getDescription() {
        userPersonalDataProductSpaceDto.setDescription("testDescription");
        assertEquals("testDescription", userPersonalDataProductSpaceDto.getDescription());
    }

    @Test
    public void setDescription() {
        userPersonalDataProductSpaceDto.setDescription("testDescription");
        assertEquals("testDescription", userPersonalDataProductSpaceDto.getDescription());
    }

    @Test
    public void getRichDescription() {
        userPersonalDataProductSpaceDto.setRichDescription("testRichDescription");
        assertEquals("testRichDescription", userPersonalDataProductSpaceDto.getRichDescription());
    }

    @Test
    public void setRichDescription() {
        userPersonalDataProductSpaceDto.setRichDescription("testRichDescription");
        assertEquals("testRichDescription", userPersonalDataProductSpaceDto.getRichDescription());
    }

    @Test
    public void isActive() {
        userPersonalDataProductSpaceDto.setActive(false);
        assertFalse(userPersonalDataProductSpaceDto.isActive());
    }

    @Test
    public void setActive() {
        userPersonalDataProductSpaceDto.setActive(false);
        assertFalse(userPersonalDataProductSpaceDto.isActive());
    }

    @Test
    public void getServers() {
        List<UserPersonalDataServerWithRolesDto> testList = new ArrayList<>();
        UserPersonalDataServerWithRolesDto userPersonalDataServerWithRolesDto = new UserPersonalDataServerWithRolesDto();
        userPersonalDataServerWithRolesDto.setName("testName");
        testList.add(userPersonalDataServerWithRolesDto);
        userPersonalDataProductSpaceDto.setServers(testList);
        assertEquals("testName", userPersonalDataProductSpaceDto.getServers().get(0).getName());


    }

    @Test
    public void setServers() {
        List<UserPersonalDataServerWithRolesDto> testList2 = new ArrayList<>();
        UserPersonalDataServerWithRolesDto userPersonalDataServerWithRolesDto2 = new UserPersonalDataServerWithRolesDto();
        userPersonalDataServerWithRolesDto2.setName("testName2");
        testList2.add(userPersonalDataServerWithRolesDto2);
        userPersonalDataProductSpaceDto.setServers(testList2);
        assertEquals("testName2", userPersonalDataProductSpaceDto.getServers().get(0).getName());

    }

    @Test
    public void getUserProductSpaceRoles() {
        List<String> testProductSpacesList = new ArrayList<>();
        String testinRole = "testingRole";
        testProductSpacesList.add(testinRole);
        userPersonalDataProductSpaceDto.setUserProductSpaceRoles(testProductSpacesList);

        assertEquals("testingRole", userPersonalDataProductSpaceDto.getUserProductSpaceRoles().get(0));


    }

    @Test
    public void setUserProductSpaceRoles() {
        List<String> testProductSpacesList = new ArrayList<>();
        String testinRole = "testingRole";
        testProductSpacesList.add(testinRole);
        userPersonalDataProductSpaceDto.setUserProductSpaceRoles(testProductSpacesList);

    }

    @Test
    public void getSaas() {
        userPersonalDataProductSpaceDto.getSaas();


    }

    @Test
    public void setSaas() {
    }
}