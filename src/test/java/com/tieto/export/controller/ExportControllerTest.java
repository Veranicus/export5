package com.tieto.export.controller;

import com.tieto.export.data.structure.UserPersonalDataDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExportControllerTest {

    ExportController exportController = new ExportController();
    UserPersonalDataDto userPersonalDataDto = new UserPersonalDataDto();

    @Test
    public void export() {

        assertNull(exportController.export(userPersonalDataDto, "gfd"));
    }


}