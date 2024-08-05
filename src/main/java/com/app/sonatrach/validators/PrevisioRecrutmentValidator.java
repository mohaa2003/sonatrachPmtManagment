package com.app.sonatrach.validators;

import com.app.sonatrach.dto.PrevisionDepartDto;
import com.app.sonatrach.dto.PrevisionRecrutmentDto;
import io.micrometer.common.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class PrevisioRecrutmentValidator {
    public static List<String> validate(PrevisionRecrutmentDto previsionRecrutmentDto){
        List<String> errors = new ArrayList<>();

        if(previsionRecrutmentDto == null){
            errors.add("Le champ niveau est obligatoire !");
            errors.add("Le champ experience est obligatoire !");
            errors.add("Le champ motif est obligatoire !");
            errors.add("Le champ type est obligatoire !");
            errors.add("Le champ diplome est obligatoire !");
            errors.add("Le champ fonctionalite est obligatoire !");
            errors.add("Le champ pmt est obligatoire !");
        }




        if(previsionRecrutmentDto.getRequiredLevel() == null){
            errors.add("Le champ niveau est obligatoire !");
        }
        if(previsionRecrutmentDto.getExperience() == null){
            errors.add("Le champ experience est obligatoire !");
        }

        if(previsionRecrutmentDto.getType() == null){
            errors.add("Le champ type est obligatoire !");
        }
        if(previsionRecrutmentDto.getDiplomatDto() == null){
            errors.add("Le champ diplome est obligatoire !");
        }
        if(previsionRecrutmentDto.getFonctionalityDto() == null){
            errors.add("Le champ fonctionalite est obligatoire !");
        }
        if(previsionRecrutmentDto.getPmtDto() == null){
            errors.add("Le champ pmt est obligatoire !");
        }
        if(!previsionRecrutmentDto.getPmtDto().isCurrentYear()){
            errors.add("Vous pouver ajouter une prevision pour cette annee seulement !");
        }
        return errors;
    }
}
