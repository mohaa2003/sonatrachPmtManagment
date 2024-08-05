package com.app.sonatrach.validators;

import com.app.sonatrach.dto.CSPDto;
import com.app.sonatrach.dto.DiplomatDto;
import io.micrometer.common.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DiplomatValidator {

    public static List<String> validate(DiplomatDto diplomatDto){
        List<String> errors = new ArrayList<>();

        if(diplomatDto == null){
            errors.add("Le champ code est obligatoire !");
            errors.add("Le champ titre est obligatoire !");
            errors.add("Le specialite code est obligatoire !");
            errors.add("Le champ type est obligatoire !");
            errors.add("Le champ niveau est obligatoire !");
        }




        if(StringUtils.isEmpty(diplomatDto.getCode())){
            errors.add("Le champ code est obligatoire !");
        }
        if(StringUtils.isEmpty(diplomatDto.getTitre())){
            errors.add("Le champ titre est obligatoire !");
        }

        if(StringUtils.isEmpty(diplomatDto.getSpecialite())){
            errors.add("Le specialite code est obligatoire !");
        }
        if(StringUtils.isEmpty(diplomatDto.getType())){
            errors.add("Le champ type est obligatoire !");
        }
        if(diplomatDto.getNiveau() == null){
            errors.add("Le champ niveau est obligatoire !");
        }
        return errors;
    }
}
