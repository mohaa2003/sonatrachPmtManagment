package com.app.sonatrach.controllers.APIs;

import com.app.sonatrach.dto.EmployeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public interface EmployeApi {
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    ResponseEntity<EmployeDto> save(@RequestBody EmployeDto employeDto);

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    ResponseEntity<EmployeDto> findById(@PathVariable Integer id);

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    ResponseEntity<List<EmployeDto>> findAll();

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/actives")
    ResponseEntity<List<EmployeDto>> findAllActives();

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Integer id);
}
