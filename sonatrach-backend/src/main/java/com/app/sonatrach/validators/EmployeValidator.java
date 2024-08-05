package com.app.sonatrach.validators;

import com.app.sonatrach.dto.DiplomatDto;
import com.app.sonatrach.dto.EmployeDto;
import io.micrometer.common.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeValidator {

    public static List<String> validate(EmployeDto employeDto){
        List<String> errors = new ArrayList<>();

        if(employeDto == null){
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
        }



        if(StringUtils.isEmpty(employeDto.getMatricule())){
            errors.add("Le champ matricule est obligatoire !");
        }
        if(StringUtils.isEmpty(employeDto.getNom())){
            errors.add("Le nom titre est obligatoire !");
        }

        if(StringUtils.isEmpty(employeDto.getPrenom())){
            errors.add("Le prenom code est obligatoire !");
        }

        if(employeDto.getSexe() == null){
            errors.add("Le champ sexe est obligatoire !");
        }
        if(employeDto.getDateNaissance() == null){
            errors.add("Le champ date de naissance est obligatoire !");
        }
        if(employeDto.getDateRect() == null){
            errors.add("Le champ date de recrutement est obligatoire !");
        }
        if(employeDto.getExperience() == null){
            errors.add("Le champ experience est obligatoire !");
        }
        if(employeDto.getEchelle() == null){
            errors.add("Le champ echelle est obligatoire !");
        }
        if(employeDto.getDiplomatDto() == null){
            errors.add("Le champ diplome est obligatoire !");
        }
        if(employeDto.getCspDto() == null){
            errors.add("Le champ csp est obligatoire !");
        }
        if(employeDto.getFonctionalityDto() == null){
            errors.add("Le champ fonctionality est obligatoire !");
        }
        if(employeDto.getStructureDto() == null){
            errors.add("Le champ structure est obligatoire !");
        }
        return errors;
    }
}
