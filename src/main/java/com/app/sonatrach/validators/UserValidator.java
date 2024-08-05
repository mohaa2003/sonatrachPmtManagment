package com.app.sonatrach.validators;

import com.app.sonatrach.dto.EmployeDto;
import com.app.sonatrach.dto.UserDto;
import io.micrometer.common.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {
    public static List<String> validate(UserDto userDto){
        List<String> errors = new ArrayList<>();

        if(userDto == null){
            errors.add("Le champ matricule est obligatoire !");
            errors.add("Le nom titre est obligatoire !");
            errors.add("Le prenom code est obligatoire !");
            errors.add("Le champ sexe est obligatoire !");
            errors.add("Le champ date de naissance est obligatoire !");
            errors.add("Le champ date de recrutement est obligatoire !");
            errors.add("Le champ experience est obligatoire !");
            errors.add("Le champ echelle est obligatoire !");
            errors.add("Le champ diplome est obligatoire !");
            errors.add("Le champ csp est obligatoire !");
            errors.add("Le champ fonctionality est obligatoire !");
            errors.add("Le champ structure est obligatoire !");
            errors.add("Le champ profil est obligatoire !");
        }

        if(StringUtils.isEmpty(userDto.getMatricule())){
            errors.add("Le champ matricule est obligatoire !");
        }
        if(StringUtils.isEmpty(userDto.getNom())){
            errors.add("Le nom titre est obligatoire !");
        }

        if(StringUtils.isEmpty(userDto.getPrenom())){
            errors.add("Le prenom code est obligatoire !");
        }

        if(userDto.getSexe() == null){
            errors.add("Le champ sexe est obligatoire !");
        }
        if(userDto.getDateNaissance() == null){
            errors.add("Le champ date de naissance est obligatoire !");
        }
        if(userDto.getDateRect() == null){
            errors.add("Le champ date de recrutement est obligatoire !");
        }
        if(userDto.getExperience() == null){
            errors.add("Le champ experience est obligatoire !");
        }
        if(userDto.getEchelle() == null){
            errors.add("Le champ echelle est obligatoire !");
        }
        if(userDto.getDiplomatDto() == null){
            errors.add("Le champ diplome est obligatoire !");
        }
        if(userDto.getCspDto() == null){
            errors.add("Le champ csp est obligatoire !");
        }
        if(userDto.getFonctionalityDto() == null){
            errors.add("Le champ fonctionality est obligatoire !");
        }
        if(userDto.getStructureDto() == null){
            errors.add("Le champ structure est obligatoire !");
        }if(userDto.getProfil() == null){
            errors.add("Le champ profil est obligatoire !");
        }
//        n'oublie pas a ajouter la verification de mot de passe en haut dans le cas ou l'objet sois nul
//        if(StringUtils.isEmpty(userDto.getPassword())){
//            errors.add("Le champ matricule est obligatoire !");
//        }
        return errors;
    }
}
