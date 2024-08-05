package com.app.sonatrach.controllers;

import com.app.sonatrach.controllers.APIs.CSPApi;
import com.app.sonatrach.dto.CSPDto;
import com.app.sonatrach.services.CSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/sonatrachapi/csp")
public class CSPController implements CSPApi {
    private CSPService cspService;

    @Autowired
    public CSPController(CSPService cspService) {
        this.cspService = cspService;
    }

    @Override
    @PostMapping
    public ResponseEntity<CSPDto> save(@RequestBody CSPDto cspDto) {
        return ResponseEntity.ok(cspService.save(cspDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CSPDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(cspService.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CSPDto>> findAll() {
        return ResponseEntity.ok(cspService.findAll());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        cspService.delete(id);
        return ResponseEntity.ok().build();
    }
}

