package com.app.sonatrach.dto;

import com.app.sonatrach.model.PMT;
import com.app.sonatrach.model.Profil;
import com.app.sonatrach.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProfilDto {
    private Integer id;

    private String titre;

    public static ProfilDto fromEntity(Profil profil) {
        if (profil == null) {
            return null;
        }
        return ProfilDto.builder()
                .id(profil.getId())
                .titre(profil.getTitre())
                .build();
    }

    public static Profil toEntity(ProfilDto profilDto){
        if (profilDto == null) {
            return null;
        }
        Profil profil = new Profil();
        profil.setId(profilDto.getId());
        profil.setTitre(profilDto.getTitre());

        return profil;
    }
}
