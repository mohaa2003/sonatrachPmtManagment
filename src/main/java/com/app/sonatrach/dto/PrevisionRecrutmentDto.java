package com.app.sonatrach.dto;

import com.app.sonatrach.model.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrevisionRecrutmentDto {
    private Integer id;

    private Niveau requiredLevel ;

    private Integer experience ;

    private String posteRequirments ;

    private TypeRecrut type ;

    private DiplomatDto diplomatDto;

    private FonctionalityDto fonctionalityDto;

    private PMTDto pmtDto;


    public static PrevisionRecrutmentDto fromEntity(PrevisionRecrutment previsionRecrutment) {
        if (previsionRecrutment == null) {
            return null;
        }
        return PrevisionRecrutmentDto.builder()
                .id(previsionRecrutment.getId())
                .requiredLevel(previsionRecrutment.getRequiredLevel())
                .experience(previsionRecrutment.getExperience())
                .posteRequirments(previsionRecrutment.getPosteRequirments())
                .type(previsionRecrutment.getType())
                .diplomatDto(DiplomatDto.fromEntity(previsionRecrutment.getDiplomat()))
                .fonctionalityDto(FonctionalityDto.fromEntity(previsionRecrutment.getFonctionality()))
                .pmtDto(PMTDto.fromEntity(previsionRecrutment.getPmt()))
                .build();
    }

    public static PrevisionRecrutment toEntity(PrevisionRecrutmentDto previsionRecrutmentDto){
        if (previsionRecrutmentDto == null) {
            return null;
        }
        PrevisionRecrutment previsionRecrutment = new PrevisionRecrutment();
        previsionRecrutment.setId(previsionRecrutmentDto.getId());
        previsionRecrutment.setRequiredLevel(previsionRecrutmentDto.getRequiredLevel());
        previsionRecrutment.setExperience(previsionRecrutmentDto.getExperience());
        previsionRecrutment.setPosteRequirments(previsionRecrutmentDto.getPosteRequirments());
        previsionRecrutment.setType(previsionRecrutmentDto.getType());
        previsionRecrutment.setFonctionality(FonctionalityDto.toEntity(previsionRecrutmentDto.getFonctionalityDto()));
        previsionRecrutment.setDiplomat(DiplomatDto.toEntity(previsionRecrutmentDto.getDiplomatDto()));
        previsionRecrutment.setPmt(PMTDto.toEntity(previsionRecrutmentDto.getPmtDto()));
        return previsionRecrutment;
    }
}
