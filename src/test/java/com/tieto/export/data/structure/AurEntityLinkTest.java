package com.tieto.export.data.structure;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class AurEntityLinkTest {

    private AurEntityLink aurEntityLink;

    @Before
    public void setup(){
      aurEntityLink = new AurEntityLink();
    }


    @Test
    public void getName() {
        aurEntityLink.setName("testName");
        assertEquals("testName", aurEntityLink.getName());
    }

    @Test
    public void setName() {
        aurEntityLink.setName("testName");
        assertEquals("testName", aurEntityLink.getName());
    }

    @Test
    public void getUrl() {
        aurEntityLink.setUrl("testUrl");
        assertEquals("testUrl", aurEntityLink.getUrl());
    }

    @Test
    public void setUrl() {
        aurEntityLink.setUrl("testUrl");
        assertEquals("testUrl", aurEntityLink.getUrl());
    }

    @Test
    public void getDescription() {
        aurEntityLink.setDescription("testDescription");
        assertEquals("testDescription", aurEntityLink.getDescription());
    }

    @Test
    public void setDescription() {
        aurEntityLink.setDescription("testDescription");
        assertEquals("testDescription", aurEntityLink.getDescription());
    }

    @Test
    public void getProtocol() {
        aurEntityLink.setProtocol("testProtocol");
        assertEquals("testProtocol", aurEntityLink.getProtocol());
    }

    @Test
    public void setProtocol() {
        aurEntityLink.setProtocol("testProtocol");
        assertEquals("testProtocol", aurEntityLink.getProtocol());
    }

}