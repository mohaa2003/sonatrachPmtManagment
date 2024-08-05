package com.app.sonatrach.controllers.APIs;

import com.app.sonatrach.dto.ActivityDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface ActivityApi {
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<ActivityDto> save(ActivityDto activityDto);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<ActivityDto> findById(Integer id);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<List<ActivityDto>> findAll();
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity delete(Integer id);
}

