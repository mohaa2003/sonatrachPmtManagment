package com.app.sonatrach.services.implementations;

import com.app.sonatrach.dto.ActivityDto;
import com.app.sonatrach.dto.EmployeDto;
import com.app.sonatrach.dto.ProfilDto;
import com.app.sonatrach.dto.UserDto;
import com.app.sonatrach.exceptions.EntityNotFoundException;
import com.app.sonatrach.exceptions.ErrorCodes;
import com.app.sonatrach.exceptions.InvalidEntityException;
import com.app.sonatrach.model.Activity;
import com.app.sonatrach.model.User;
import com.app.sonatrach.repositories.ActivityRepo;
import com.app.sonatrach.services.ActivityService;
import com.app.sonatrach.validators.ActivityValidator;
import com.app.sonatrach.validators.ProfilValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ActivityServiceImp implements ActivityService {
    @Autowired
    private ActivityRepo activityRepo;
    @Override
    public ActivityDto save(ActivityDto activityDto) {
        List<String> errors = ActivityValidator.validate(activityDto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("activite non valide", ErrorCodes.ACTIVITY_NOT_VALID, errors);
        }
        return ActivityDto.fromEntity(activityRepo.save(ActivityDto.toEntity(activityDto)));

    }

    @Override
    public ActivityDto findById(Integer id) {
        if(id == null){
            log.error("activite non valide");
            return null;
        }
        Optional<Activity> activity = activityRepo.findById(id);
        return Optional.of(ActivityDto.fromEntity(activity.get()))
                .orElseThrow(() -> new EntityNotFoundException("Aucune activite est trouve avec l'id "+id+" dans la base de donnees", ErrorCodes.EMPLOYE_NOT_FOUND));

    }

    @Override
    public List<ActivityDto> findAll() {
        return activityRepo.findAll().stream()
                .map(ActivityDto::fromEntity).collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("activite not valide");
        }
        activityRepo.deleteById(id);

    }
}
