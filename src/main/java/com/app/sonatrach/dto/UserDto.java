package com.app.sonatrach.dto;

import com.app.sonatrach.model.Employe;
import com.app.sonatrach.model.Profil;
import com.app.sonatrach.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class UserDto extends EmployeDto {

    private String image;

    private ProfilDto profil;
    //password dans toutes les autres couche !

    public static UserDto fromEntity(User user) {
        if (user == null) {
            return null;
        }
        return UserDto.builder()
                .id(user.getId())
                .matricule(user.getMatricule())
                .image(user.getImage())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .dateNaissance(user.getDateNaissance())
                .sexe(user.getSexe())
                .dateRect(user.getDateRect())
                .experience(user.getExperience())
                .echelle(user.getEchelle())
                .diplomatDto(DiplomatDto.fromEntity(user.getDiplomat()))
                .fonctionalityDto(FonctionalityDto.fromEntity(user.getFonctionality()))
                .cspDto(CSPDto.fromEntity(user.getCsp()))
                .structureDto(StructureDto.fromEntity(user.getStructure()))
                .profil(ProfilDto.fromEntity(user.getProfil()))
                .build();
    }

    public static User toEntity(UserDto userDto){
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setMatricule(userDto.getMatricule());
        user.setImage(userDto.getImage());
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setDateNaissance(userDto.getDateNaissance());
        user.setSexe(userDto.getSexe());
        user.setDateRect(userDto.getDateRect());
        user.setExperience(userDto.getExperience());
        user.setEchelle(userDto.getEchelle());
        user.setDiplomat(DiplomatDto.toEntity(userDto.getDiplomatDto()));
        user.setFonctionality(FonctionalityDto.toEntity(userDto.getFonctionalityDto()));
        user.setCsp(CSPDto.toEntity(userDto.getCspDto()));
        user.setProfil(ProfilDto.toEntity(userDto.getProfil()));
        return user;
    }
}
