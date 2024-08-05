package com.app.sonatrach.validators;

import com.app.sonatrach.dto.CSPDto;
import java.util.ArrayList;
import java.util.List;

public class CSPValidator {


    public static List<String> validate(CSPDto cspDto){
        List<String> errors = new ArrayList<>();

        if(cspDto == null){
            errors.add("Le champ cadre echelle maximal est obligatoire !");
            errors.add("Le champ echelle minimal est obligatoire !");
            errors.add("Le champ type est obligatoire !");
            errors.add("Le champ categorie est obligatoire !");
        }


        if(cspDto.getType() == null){
            errors.add("Le champ type est obligatoire !");
        }

        if(cspDto.getMaxEchelle() == null){
            errors.add("Le champ echelle maximal est obligatoire !");
        }
        if(cspDto.getMinEchelle() == null){
            errors.add("Le champ echelle minimal est obligatoire !");
        }
        if(cspDto.getCategory() == null){
            errors.add("Le champ categorie est obligatoire !");
        }
        if(cspDto.getMinEchelle() < 10 || cspDto.getMinEchelle()>100){
            errors.add("La valeur de l'echelle min est invalide");
        }
        if(cspDto.getMaxEchelle()<10 || cspDto.getMaxEchelle()>100){
            errors.add("La valeur de l'echelle max est invalide");
        }
        return errors;
    }
}
