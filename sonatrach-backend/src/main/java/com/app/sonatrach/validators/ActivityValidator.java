package com.app.sonatrach.validators;

import com.app.sonatrach.dto.ActivityDto;
import com.app.sonatrach.dto.FonctionalityDto;
import com.app.sonatrach.model.CatgoryActivity;
import io.micrometer.common.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.StringUtils.hasLength;

public class ActivityValidator {

    public static List<String> validate(ActivityDto activityDto){
        List<String> errors = new ArrayList<>();

        if(activityDto == null){
            errors.add("Le champ code est obligatoire !");
            errors.add("Le champ titre est obligatoire !");
            errors.add("Le champ category est obligatoire !");
        }



        if(StringUtils.isEmpty(activityDto.getCode())){
            errors.add("Le champ code est obligatoire !");
        }
        if(StringUtils.isEmpty(activityDto.getTitre())){
            errors.add("Le champ titre est obligatoire !");
        }
        if(activityDto.getCategory() == null){
            errors.add("Le champ category est obligatoire !");
        }
        return errors;
    }


}
