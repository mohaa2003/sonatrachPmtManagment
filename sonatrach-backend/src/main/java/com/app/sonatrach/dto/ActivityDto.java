package com.app.sonatrach.dto;

import com.app.sonatrach.model.Activity;
import com.app.sonatrach.model.CatgoryActivity;
import com.app.sonatrach.model.Fonctionality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ActivityDto {
    private Integer id;

    private String code;

    private String titre;

    private CatgoryActivity category;



    public static ActivityDto fromEntity(Activity activity) {
        if (activity == null) {
            return null;
        }
        return ActivityDto.builder()
                .id(activity.getId())
                .code(activity.getCode())
                .titre(activity.getTitre())
                .category(activity.getCategory())
                .build();
    }

    public static Activity toEntity(ActivityDto activityDto){
        if (activityDto == null) {
            return null;
        }
        Activity activity = new Activity();
        activity.setId(activityDto.getId());
        activity.setCode(activityDto.getCode());
        activity.setTitre(activityDto.getTitre());
        activity.setCategory(activityDto.getCategory());
        return activity;
    }
}