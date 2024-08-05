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
public class StructureDto {
    private Integer id;

    private String designation ;

    private Wilaya lieu ;


    public static StructureDto fromEntity(Structure structure) {
        if (structure == null) {
            return null;
        }
        return StructureDto.builder()
                .id(structure.getId())
                .designation(structure.getDesignation())
                .lieu(structure.getLieu())
               .build();
    }

    public static Structure toEntity(StructureDto structureDto){
        if (structureDto == null) {
            return null;
        }
        Structure structure = new Structure();
        structure.setId(structureDto.getId());
        structure.setDesignation(structureDto.getDesignation());
        structure.setLieu(structureDto.getLieu());

        return structure;
    }
}
