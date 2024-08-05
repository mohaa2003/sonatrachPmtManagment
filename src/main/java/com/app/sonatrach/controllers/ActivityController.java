package com.app.sonatrach.controllers;

import com.app.sonatrach.controllers.APIs.ActivityApi;
import com.app.sonatrach.dto.ActivityDto;
import com.app.sonatrach.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/sonatrachapi/activity")
public class ActivityController implements ActivityApi {
    private ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Override
    @PostMapping
    public ResponseEntity<ActivityDto> save(@RequestBody ActivityDto activityDto) {
        return ResponseEntity.ok(activityService.save(activityDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ActivityDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(activityService.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ActivityDto>> findAll() {
        return ResponseEntity.ok(activityService.findAll());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        activityService.delete(id);
        return ResponseEntity.ok().build();
    }
}
