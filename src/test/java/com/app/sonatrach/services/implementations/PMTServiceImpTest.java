package com.app.sonatrach.services.implementations;

import com.app.sonatrach.dto.PMTDto;
import com.app.sonatrach.services.EmployeService;
import com.app.sonatrach.services.PMTService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PMTServiceImpTest {
    @Autowired
    private PMTService pmtService;
    @Test
    public void shouldSavePMT(){
        PMTDto expectedDto = PMTDto.builder()
                .duration(4)
                .aneeDebut( LocalDate.parse("2024-01-01").atStartOfDay().toInstant(ZoneOffset.UTC)).build();

        PMTDto savedPMT = pmtService.save(expectedDto);

        assertNotNull(savedPMT);
        assertEquals(savedPMT.getDuration(),expectedDto.getDuration());
        assertEquals(savedPMT.getAneeDebut(),expectedDto.getAneeDebut());
    }


}