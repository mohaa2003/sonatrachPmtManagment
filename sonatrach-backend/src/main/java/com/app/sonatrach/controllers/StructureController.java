package com.app.sonatrach.controllers;

import com.app.sonatrach.controllers.APIs.StructureApi;
import com.app.sonatrach.dto.StructureDto;
import com.app.sonatrach.services.StructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/sonatrachapi/structure")
public class StructureController implements StructureApi {
    private StructureService structureService;

    @Autowired
    public StructureController(StructureService structureService) {
        this.structureService = structureService;
    }

    @Override
    @PostMapping
    public ResponseEntity<StructureDto> save(@RequestBody StructureDto structureDto) {
        return ResponseEntity.ok(structureService.save(structureDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<StructureDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(structureService.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<StructureDto>> findAll() {
        return ResponseEntity.ok(structureService.findAll());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        structureService.delete(id);
        return ResponseEntity.ok().build();
    }
}

