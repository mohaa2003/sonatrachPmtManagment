package com.app.sonatrach.dto;

import com.app.sonatrach.model.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiplomatDto {
    private Integer id;

    private String code;

    private String titre;

    private String specialite;

    private String type;

    private Niveau niveau;


    public static DiplomatDto fromEntity(Diplomat diplomat) {
        if (diplomat == null) {
            return null;
        }
        return DiplomatDto.builder()
                .id(diplomat.getId())
                .code(diplomat.getCode())
                .titre(diplomat.getTitre())
                .specialite(diplomat.getSpecialite())
                .type(diplomat.getType())
                .niveau(diplomat.getNiveau())
                .build();
    }

    public static Diplomat toEntity(DiplomatDto diplomatDto){
        if (diplomatDto == null) {
            return null;
        }
        Diplomat diplomat = new Diplomat();
        diplomat.setId(diplomatDto.getId());
        diplomat.setCode(diplomatDto.getCode());
        diplomat.setTitre(diplomatDto.getTitre());
        diplomat.setSpecialite(diplomatDto.getSpecialite());
        diplomat.setType(diplomatDto.getType());
        diplomat.setNiveau(diplomatDto.getNiveau());

        return diplomat;
    }
}
