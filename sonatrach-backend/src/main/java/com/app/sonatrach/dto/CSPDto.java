package com.app.sonatrach.dto;

import com.app.sonatrach.model.CSP;
import com.app.sonatrach.model.CategoryCSP;
import com.app.sonatrach.model.TypeCSP;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class CSPDto {
    private Integer id;

    private TypeCSP type;

    private Integer maxEchelle;

    private Integer minEchelle;

    private CategoryCSP category;


    public static CSPDto fromEntity(CSP csp) {
        if (csp == null) {
            return null;
        }
        return CSPDto.builder()
                .id(csp.getId())
                .type(csp.getType())
                .maxEchelle(csp.getMaxEchelle())
                .minEchelle(csp.getMinEchelle())
                .category(csp.getCategory())
                .build();
    }

    public static CSP toEntity(CSPDto cspDto){
        if (cspDto == null) {
            return null;
        }
        CSP csp = new CSP();
        csp.setId(cspDto.getId());
        csp.setMaxEchelle(cspDto.getMaxEchelle());
        csp.setMinEchelle(cspDto.getMinEchelle());
        csp.setType(cspDto.getType());
        csp.setCategory(cspDto.getCategory());
        return csp;
    }
}
