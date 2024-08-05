package com.app.sonatrach.dto;

import com.app.sonatrach.model.*;
import jakarta.persistence.*;
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
public class FonctionalityDto {
    private Integer id;

    private String intitule ;

    private Integer baseEchelle ;


    private ActivityDto activityDto;

    public static FonctionalityDto fromEntity(Fonctionality fonctionality) {
        if (fonctionality == null) {
            return null;
        }
        return FonctionalityDto.builder()
                .id(fonctionality.getId())
                .intitule(fonctionality.getIntitule())
                .baseEchelle(fonctionality.getBaseEchelle())
                .activityDto(ActivityDto.fromEntity(fonctionality.getActivity()))
                .build();
    }

    public static Fonctionality toEntity(FonctionalityDto fonctionalityDto){
        if (fonctionalityDto == null) {
            return null;
        }
        Fonctionality fonctionality = new Fonctionality();
        fonctionality.setId(fonctionalityDto.getId());
        fonctionality.setIntitule(fonctionalityDto.getIntitule());
        fonctionality.setBaseEchelle(fonctionalityDto.getBaseEchelle());
        fonctionality.setActivity(ActivityDto.toEntity(fonctionalityDto.getActivityDto()));

        return fonctionality;
    }
}
