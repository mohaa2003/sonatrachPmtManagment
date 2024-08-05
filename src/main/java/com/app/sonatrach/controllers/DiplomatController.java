package com.app.sonatrach.controllers;

import com.app.sonatrach.controllers.APIs.DiplomatApi;
import com.app.sonatrach.dto.DiplomatDto;
import com.app.sonatrach.services.DiplomatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/sonatrachapi/diplomat")
public class DiplomatController implements DiplomatApi {
    private DiplomatService diplomatService;

    @Autowired
    public DiplomatController(DiplomatService diplomatService) {
        this.diplomatService = diplomatService;
    }

    @Override
    @PostMapping
    public ResponseEntity<DiplomatDto> save(@RequestBody DiplomatDto diplomatDto) {
        return ResponseEntity.ok(diplomatService.save(diplomatDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<DiplomatDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(diplomatService.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<DiplomatDto>> findAll() {
        return ResponseEntity.ok(diplomatService.findAll());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        diplomatService.delete(id);
        return ResponseEntity.ok().build();
    }
}

