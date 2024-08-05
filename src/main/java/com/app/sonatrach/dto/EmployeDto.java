package com.app.sonatrach.dto;

import com.app.sonatrach.model.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class EmployeDto {
    private Integer id;

    private String matricule;

    private String nom;

    private String prenom;

    private Instant dateNaissance;

    private Sexe sexe;

    private Instant dateRect;

    private Integer experience;

    private boolean desactive;

    private Integer echelle;

    private DiplomatDto diplomatDto;

    private FonctionalityDto fonctionalityDto;

    private CSPDto cspDto;

    private StructureDto structureDto;


    public int calculateAge() {
        if (this.getDateNaissance() == null) {
            return 0;
        }
        LocalDate birthDate = LocalDate.ofInstant(this.getDateNaissance(), ZoneId.systemDefault());
        LocalDate currentDate = LocalDate.now();

        if (this.getDateNaissance() != null) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public static EmployeDto fromEntity(Employe employe) {
        if (employe == null) {
            return null;
        }
        return EmployeDto.builder()
                .id(employe.getId())
                .matricule(employe.getMatricule())
                .nom(employe.getNom())
                .prenom(employe.getPrenom())
                .dateNaissance(employe.getDateNaissance())
                .sexe(employe.getSexe())
                .desactive(employe.getDesactive())
                .dateRect(employe.getDateRect())
                .experience(employe.getExperience())
                .echelle(employe.getEchelle())
                .diplomatDto(DiplomatDto.fromEntity(employe.getDiplomat()))
                .fonctionalityDto(FonctionalityDto.fromEntity(employe.getFonctionality()))
                .cspDto(CSPDto.fromEntity(employe.getCsp()))
                .structureDto(StructureDto.fromEntity(employe.getStructure()))
                .build();
    }

    public static Employe toEntity(EmployeDto employeDto){
        if (employeDto == null) {
            return null;
        }
        Employe employe = new Employe();
        employe.setId(employeDto.getId());
        employe.setMatricule(employeDto.getMatricule());
        employe.setNom(employeDto.getNom());
        employe.setPrenom(employeDto.getPrenom());
        employe.setDesactive(employeDto.getDesactive());
        employe.setDateNaissance(employeDto.getDateNaissance());
        employe.setSexe(employeDto.getSexe());
        employe.setDateRect(employeDto.getDateRect());
        employe.setExperience(employeDto.getExperience());
        employe.setEchelle(employeDto.getEchelle());
        employe.setDiplomat(DiplomatDto.toEntity(employeDto.getDiplomatDto()));
        employe.setFonctionality(FonctionalityDto.toEntity(employeDto.getFonctionalityDto()));
        employe.setCsp(CSPDto.toEntity(employeDto.getCspDto()));
        employe.setStructure(StructureDto.toEntity(employeDto.getStructureDto()));

        return employe;
    }

    private boolean getDesactive() {
        return this.desactive;
    }
}
