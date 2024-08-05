package com.app.sonatrach.controllers;

import com.app.sonatrach.controllers.APIs.PrevisionDepartApi;
import com.app.sonatrach.dto.PrevisionDepartDto;
import com.app.sonatrach.services.PrevisionDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user/sonatrachapi/depart")

public class PrevisionDepartController implements PrevisionDepartApi {
    private PrevisionDepartService previsionDepartService;
    @Autowired
    public PrevisionDepartController(PrevisionDepartService previsionDepartService) {
        this.previsionDepartService = previsionDepartService;
    }

    @Override
    @PostMapping
    public ResponseEntity<PrevisionDepartDto> save(@RequestBody PrevisionDepartDto previsionDepartDto) {
        return ResponseEntity.ok(previsionDepartService.save(previsionDepartDto));
    }

    @Override
    @GetMapping("/{id}")

    public ResponseEntity<PrevisionDepartDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(previsionDepartService.findById(id));

    }

    @Override
    @GetMapping
    public ResponseEntity<List<PrevisionDepartDto>> findAll() {
        return ResponseEntity.ok(previsionDepartService.findAll());
    }

    @Override
    @GetMapping("/confirm/{id}")
    public ResponseEntity confirmDepart(@PathVariable Integer id) {

        previsionDepartService.confirmDepart(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping("/inconfirm/{id}")
    public ResponseEntity inconfirmDepart(@PathVariable Integer id) {

        previsionDepartService.inconfirmDepart(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping("/{id}")

    public ResponseEntity delete(@PathVariable Integer id) {

        previsionDepartService.delete(id);
        return ResponseEntity.ok().build();
    }
}