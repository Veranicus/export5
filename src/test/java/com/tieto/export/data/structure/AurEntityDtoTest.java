package com.tieto.export.data.structure;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class AurEntityDtoTest {

    private AurEntityDto aurEntityDto;

    @Before
    public void setup() {
        aurEntityDto = new AurEntityDto();
    }


    @Test
    public void getEntid() {
        aurEntityDto.setEntid("idTest");
        assertEquals("idTest", aurEntityDto.getEntid());


    }

    @Test
    public void setEntid() {
        aurEntityDto.setEntid("idTest");
        assertEquals("idTest", aurEntityDto.getEntid());
    }

    @Test
    public void getPsuid() {
        aurEntityDto.setPsuid("psuidTest");
        assertEquals("psuidTest", aurEntityDto.getPsuid());
    }

    @Test
    public void setPsuid() {
        aurEntityDto.setPsuid("psuidTest");
        assertEquals("psuidTest", aurEntityDto.getPsuid());
    }


    @Test
    public void getType() {
        aurEntityDto.setType("testType");
        assertEquals("testType", aurEntityDto.getType());
    }

    @Test
    public void setType() {
        aurEntityDto.setType("testType");
        assertEquals("testType", aurEntityDto.getType());
    }

    @Test
    public void getState() {
        aurEntityDto.setState(aurEntityDto.getState());
        assertEquals("DELETED", aurEntityDto.getState().DELETED.toString());
    }

    @Test
    public void setState() {
        aurEntityDto.setState(aurEntityDto.getState());
        assertEquals("DELETED", aurEntityDto.getState().DELETED.toString());
    }

    @Test
    public void getFields() {
        Map<String, String> testMap = new HashMap<String, String>() {
            {
                put("key1", "value1");
                put("key2", "value2");
            }
        };
        aurEntityDto.setFields(testMap);
        assertEquals("value1", aurEntityDto.getFields().get("key1"));
    }

    @Test
    public void setFields() {
        Map<String, String> testMap = new HashMap<String, String>() {
            {
                put("key1", "value1");
                put("key2", "value2");
            }
        };
        aurEntityDto.setFields(testMap);
        assertEquals("value1", aurEntityDto.getFields().get("key1"));
    }

    @Test
    public void getLinks() {

//        List<AurEntityLink> testList = new ArrayList<>();
//        AurEntityLink testLink = new AurEntityLink();
//        testLink.setName("testName");
//        testList.set(0,testLink);
//
//        aurEntityDto.setLinks(testList);
//
//        assertEquals("testName", aurEntityDto.getLinks().get(0).getName());

    }

    @Test
    public void setLinks() {
    }

}