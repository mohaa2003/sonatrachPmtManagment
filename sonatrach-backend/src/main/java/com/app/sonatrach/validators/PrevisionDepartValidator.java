package com.app.sonatrach.validators;

import com.app.sonatrach.dto.PMTDto;
import com.app.sonatrach.dto.PrevisionDepartDto;

import java.util.ArrayList;
import java.util.List;


public class PrevisionDepartValidator {
    public static List<String> validate(PrevisionDepartDto previsionDepartDto){
        List<String> errors = new ArrayList<>();

        if(previsionDepartDto == null){
            errors.add("Le champ annee est obligatoire !");
            errors.add("Le champ motif est obligatoire !");
            errors.add("Le champ confirmation est obligatoire !");
            errors.add("Le champ pmt est obligatoire !");
            errors.add("Le champ employe est obligatoire !");
        }




        if(previsionDepartDto.getAnnee() == null){
            errors.add("Le champ annee est obligatoire !");
        }
        if(previsionDepartDto.getMotif() == null){
            errors.add("Le champ motif est obligatoire !");
        }
        if(previsionDepartDto.getIsConfirmed() == null){
            errors.add("Le champ confirmation est obligatoire !");
        }
        if(previsionDepartDto.getPmtDto() == null){
            errors.add("Le champ pmt est obligatoire !");
        }
        if(!previsionDepartDto.getPmtDto().isCurrentYear()){
            errors.add("Vous pouver ajouter une prevision pour cette annee seulement !");
        }
        if(previsionDepartDto.getEmployeDto() == null){
            errors.add("Le champ employe est obligatoire !");
        }

        return errors;
    }
}
