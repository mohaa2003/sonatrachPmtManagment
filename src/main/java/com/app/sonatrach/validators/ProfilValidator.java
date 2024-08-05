package com.app.sonatrach.validators;

import com.app.sonatrach.dto.PMTDto;
import com.app.sonatrach.dto.ProfilDto;
import io.micrometer.common.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProfilValidator {
    public static List<String> validate(ProfilDto profilDto){
        List<String> errors = new ArrayList<>();

        if(profilDto == null){
            errors.add("Le champ titre est obligatoire !");
        }

        if(StringUtils.isEmpty(profilDto.getTitre())){
            errors.add("Le champ titre est obligatoire !");
        }

        return errors;
    }
}
