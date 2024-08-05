package com.app.sonatrach.validators;

import com.app.sonatrach.dto.DiplomatDto;
import com.app.sonatrach.dto.FonctionalityDto;
import io.micrometer.common.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class FonctionnalityValidator {
    public static List<String> validate(FonctionalityDto fonctionalityDto){
        List<String> errors = new ArrayList<>();

        if(fonctionalityDto == null){
            errors.add("Le base echelle type est obligatoire !");
            errors.add("Le champ activite est obligatoire !");
            errors.add("Le champ intitule est obligatoire !");
        }



        if(fonctionalityDto.getBaseEchelle() == null){
            errors.add("Le base echelle type est obligatoire !");
        }

        if(fonctionalityDto.getActivityDto() == null){
            errors.add("Le champ activite est obligatoire !");
        }

        if(StringUtils.isEmpty(fonctionalityDto.getIntitule())){
            errors.add("Le champ intitule est obligatoire !");
        }
        return errors;
    }
}
