package com.app.sonatrach.dto;

import com.app.sonatrach.model.Employe;
import com.app.sonatrach.model.InactiveEmploye;
import com.app.sonatrach.model.MotifDepart;
import com.app.sonatrach.model.Structure;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class InactiveEmployeDto extends EmployeDto {
    private Instant departYear ;

    private MotifDepart motif;

    private StructureDto structureDest;

    public static InactiveEmployeDto fromEntity(InactiveEmploye employe) {
        if (employe == null) {
            return null;
        }
        return InactiveEmployeDto.builder()
                .departYear(employe.getDepartYear())
                .id(employe.getId())
                .matricule(employe.getMatricule())
                .nom(employe.getNom())
                .prenom(employe.getPrenom())
                .desactive(true)
                .dateNaissance(employe.getDateNaissance())
                .sexe(employe.getSexe())
                .motif(employe.getMotif())
                .dateRect(employe.getDateRect())
                .experience(employe.getExperience())
                .echelle(employe.getEchelle())
                .diplomatDto(DiplomatDto.fromEntity(employe.getDiplomat()))
                .fonctionalityDto(FonctionalityDto.fromEntity(employe.getFonctionality()))
                .cspDto(CSPDto.fromEntity(employe.getCsp()))
                .structureDto(StructureDto.fromEntity(employe.getStructure()))
                .structureDest(StructureDto.fromEntity(employe.getStructureDest()))
                .build();
    }

    public static InactiveEmploye toEntity(InactiveEmployeDto employeDto){
        if (employeDto == null) {
            return null;
        }
        InactiveEmploye employe = new InactiveEmploye();
        employe.setId(employeDto.getId());
        employe.setMatricule(employeDto.getMatricule());
        employe.setNom(employeDto.getNom());
        employe.setPrenom(employeDto.getPrenom());
        employe.setDateNaissance(employeDto.getDateNaissance());
        employe.setSexe(employeDto.getSexe());
        employe.setDesactive(true);
        employe.setDateRect(employeDto.getDateRect());
        employe.setExperience(employeDto.getExperience());
        employe.setEchelle(employeDto.getEchelle());
        employe.setMotif(employeDto.getMotif());
        employe.setDiplomat(DiplomatDto.toEntity(employeDto.getDiplomatDto()));
        employe.setFonctionality(FonctionalityDto.toEntity(employeDto.getFonctionalityDto()));
        employe.setCsp(CSPDto.toEntity(employeDto.getCspDto()));
        employe.setDepartYear(employeDto.getDepartYear());
        employe.setStructureDest(StructureDto.toEntity(employeDto.getStructureDest()));
        return employe;
    }
}
