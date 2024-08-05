package com.app.sonatrach.controllers;

import com.app.sonatrach.controllers.APIs.EmployeApi;
import com.app.sonatrach.dto.EmployeDto;
import com.app.sonatrach.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user/sonatrachapi/employe")
public class EmployeController implements EmployeApi {
    private EmployeService employeService;

    @Autowired
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @Override
    public ResponseEntity<EmployeDto> save(EmployeDto employeDto) {
        return ResponseEntity.ok(employeService.save(employeDto));
    }

    @Override
    public ResponseEntity<EmployeDto> findById(Integer id) {
        return ResponseEntity.ok(employeService.findById(id));
    }

    @Override
    public ResponseEntity<List<EmployeDto>> findAll() {
        return ResponseEntity.ok(employeService.findAll());
    }

    @Override
    public ResponseEntity<List<EmployeDto>> findAllActives() {
        return ResponseEntity.ok(employeService.findAllActives());
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        employeService.delete(id);
        return ResponseEntity.ok().build();
    }
}




