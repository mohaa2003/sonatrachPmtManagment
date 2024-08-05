package com.app.sonatrach.validators;

import com.app.sonatrach.dto.ProfilDto;
import com.app.sonatrach.dto.StructureDto;
import io.micrometer.common.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StructureValidator {
    public static List<String> validate(StructureDto structureDto){
        List<String> errors = new ArrayList<>();

        if(structureDto == null){
            errors.add("Le champ designation est obligatoire !");
            errors.add("Le champ lieu est obligatoire !");
        }



        if(StringUtils.isEmpty(structureDto.getDesignation())){
            errors.add("Le champ designation est obligatoire !");
        }
        if(structureDto.getLieu() == null){
            errors.add("Le champ lieu est obligatoire !");
        }

        return errors;
    }
}
