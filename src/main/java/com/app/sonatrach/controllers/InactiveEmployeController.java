package com.app.sonatrach.controllers;

import com.app.sonatrach.controllers.APIs.InactiveEmployeApi;
import com.app.sonatrach.dto.InactiveEmployeDto;
import com.app.sonatrach.services.InactiveEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user/sonatrachapi/inactiveemploye")
public class InactiveEmployeController implements InactiveEmployeApi {
    private InactiveEmployeService inactiveEmployeService;
    @Autowired
    public InactiveEmployeController(InactiveEmployeService inactiveEmployeService) {
        this.inactiveEmployeService = inactiveEmployeService;
    }

    @Override
    @PostMapping

    public ResponseEntity<InactiveEmployeDto> save(@RequestBody InactiveEmployeDto inactiveEmployeDto) {
        return ResponseEntity.ok(inactiveEmployeService.save(inactiveEmployeDto));
    }

    @Override
    @GetMapping("/{id}")

    public ResponseEntity<InactiveEmployeDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(inactiveEmployeService.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<InactiveEmployeDto>> findAll() {
        return ResponseEntity.ok(inactiveEmployeService.findAll());
    }

    @Override
    @DeleteMapping("/{id}")

    public ResponseEntity delete(@PathVariable Integer id) {

        inactiveEmployeService.delete(id);
        return ResponseEntity.ok().build();    }
}

