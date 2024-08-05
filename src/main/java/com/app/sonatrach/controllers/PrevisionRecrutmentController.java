package com.app.sonatrach.controllers;

import com.app.sonatrach.controllers.APIs.PrevisionRecrutmentApi;
import com.app.sonatrach.dto.PrevisionRecrutmentDto;
import com.app.sonatrach.services.PrevisionRecrutmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user/sonatrachapi/recrutment")

public class PrevisionRecrutmentController implements PrevisionRecrutmentApi {
    private PrevisionRecrutmentService previsionRecrutmentService;
    @Autowired
    public PrevisionRecrutmentController(PrevisionRecrutmentService previsionRecrutmentService) {
        this.previsionRecrutmentService = previsionRecrutmentService;
    }

    @Override
    @PostMapping
    public ResponseEntity<PrevisionRecrutmentDto> save(@RequestBody PrevisionRecrutmentDto previsionRecrutmentDto) {
        return ResponseEntity.ok(previsionRecrutmentService.save(previsionRecrutmentDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PrevisionRecrutmentDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(previsionRecrutmentService.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PrevisionRecrutmentDto>> findAll() {
        return ResponseEntity.ok(previsionRecrutmentService.findAll());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {

        previsionRecrutmentService.delete(id);
        return ResponseEntity.ok().build();    }
}

