package com.app.sonatrach.controllers;

import com.app.sonatrach.controllers.APIs.PMTApi;
import com.app.sonatrach.dto.PMTDto;
import com.app.sonatrach.services.PMTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user/sonatrachapi/pmt")

public class PMTController implements PMTApi {
    private PMTService pmtService;
    @Autowired
    public PMTController(PMTService pmtService) {
        this.pmtService = pmtService;
    }

    @Override
    @PostMapping

    public ResponseEntity<PMTDto> save(@RequestBody PMTDto pmtDto) {
        return ResponseEntity.ok(pmtService.save(pmtDto));
    }

    @Override
    @GetMapping("/{id}")

    public ResponseEntity<PMTDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(pmtService.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PMTDto>> findAll() {
        return ResponseEntity.ok(pmtService.findAll());
    }

    @Override
    @DeleteMapping("/{id}")

    public ResponseEntity delete(@PathVariable Integer id) {

        pmtService.delete(id);
        return ResponseEntity.ok().build();    }
}