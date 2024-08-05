package com.app.sonatrach.validators;

import com.app.sonatrach.dto.FonctionalityDto;
import com.app.sonatrach.dto.PMTDto;
import io.micrometer.common.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PMTValidator {
    public static List<String> validate(PMTDto pmtDto){
        List<String> errors = new ArrayList<>();

        if(pmtDto == null){
                errors.add("Le champ anneeDebut est obligatoire !");
                errors.add("Le champ duration est obligatoire !");
        }



        if(!pmtDto.isCurrentYear()){
            errors.add("On peut ajouter,modifier et supprimer le pmt de cette annee uniquement !");
        }
        if(pmtDto.getAneeDebut() == null){
            errors.add("Le champ anneeDebut est obligatoire !");
        }
        if(pmtDto.getDuration() == null){
            errors.add("Le champ duration est obligatoire !");
        }

        return errors;
    }
}
