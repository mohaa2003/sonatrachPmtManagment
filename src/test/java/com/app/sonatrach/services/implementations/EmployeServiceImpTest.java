package com.app.sonatrach.services.implementations;

import com.app.sonatrach.dto.*;
import com.app.sonatrach.model.Sexe;
import com.app.sonatrach.services.EmployeService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImpTest {
    @Autowired
    EmployeService employeService;
    public void shouldSaveEmploye(){
       EmployeDto expectedEmploye = EmployeDto.builder()
               .matricule("pp11234")
               .nom("Saido")
               .prenom("Djanel")
               .dateNaissance( LocalDate.parse("2002-01-12").atStartOfDay().toInstant(ZoneOffset.UTC))
               .sexe(Sexe.HOMME)
               .dateRect(LocalDate.parse("2022-01-12").atStartOfDay().toInstant(ZoneOffset.UTC))
               .experience(3)
               .echelle(16).build();
//               .diplomatDto(DiplomatDto.fromEntity(employe.getDiplomat()))
//               .fonctionalityDto(FonctionalityDto.fromEntity(employe.getFonctionality()))
//               .cspDto(CSPDto.fromEntity(employe.getCsp()))
//               .structureDto(StructureDto.fromEntity(employe.getStructure()))
                EmployeDto savedEmploye = employeService.save(expectedEmploye);
                assertEquals(savedEmploye.getMatricule(),expectedEmploye.getMatricule());
        assertEquals(savedEmploye.getMatricule(),expectedEmploye.getMatricule());
        assertEquals(savedEmploye.getNom(),expectedEmploye.getNom());
        assertEquals(savedEmploye.getPrenom(),expectedEmploye.getPrenom());
        assertEquals(savedEmploye.getDateNaissance(),expectedEmploye.getDateNaissance());
        assertEquals(savedEmploye.getSexe(),expectedEmploye.getSexe());
        assertEquals(savedEmploye.getDateRect(),expectedEmploye.getDateRect());
        assertEquals(savedEmploye.getExperience(),expectedEmploye.getExperience());
        assertEquals(savedEmploye.getEchelle(),expectedEmploye.getEchelle());



    }
}