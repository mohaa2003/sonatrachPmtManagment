package com.app.sonatrach.controllers;

import com.app.sonatrach.controllers.APIs.FonctionaityApi;
import com.app.sonatrach.dto.FonctionalityDto;
import com.app.sonatrach.model.Fonctionality;
import com.app.sonatrach.services.FonctionaityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/sonatrachapi/fonctionality")
public class FonctionalityController implements FonctionaityApi {
    private FonctionaityService fonctionalityService;

    @Autowired
    public FonctionalityController(FonctionaityService fonctionalityService) {
        this.fonctionalityService = fonctionalityService;
    }

    @Override
    @PostMapping
    public ResponseEntity<FonctionalityDto> save(@RequestBody FonctionalityDto fonctionalityDto) {
        return ResponseEntity.ok(fonctionalityService.save(fonctionalityDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<FonctionalityDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(fonctionalityService.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<FonctionalityDto>> findAll() {
        return ResponseEntity.ok(fonctionalityService.findAll());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        fonctionalityService.delete(id);
        return ResponseEntity.ok().build();
    }
}

