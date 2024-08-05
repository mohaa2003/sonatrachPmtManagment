package com.app.sonatrach.services;

import com.app.sonatrach.dto.ActivityDto;

import java.util.List;

public interface ActivityService {
    ActivityDto save(ActivityDto activityDto);
    ActivityDto findById(Integer id);
    List<ActivityDto> findAll();
    void delete(Integer id);
}
