package com.app.sonatrach.controllers;

import com.app.sonatrach.controllers.APIs.ProfilApi;
import com.app.sonatrach.dto.ProfilDto;
import com.app.sonatrach.services.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/sonatrachapi/profil")
public class ProfilController implements ProfilApi {
    private ProfilService profilService;

    @Autowired
    public ProfilController(ProfilService profilService) {
        this.profilService = profilService;
    }

    @Override
    @PostMapping
    public ResponseEntity<ProfilDto> save(@RequestBody ProfilDto profilDto) {
        return ResponseEntity.ok(profilService.save(profilDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProfilDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(profilService.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProfilDto>> findAll() {
        return ResponseEntity.ok(profilService.findAll());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        profilService.delete(id);
        return ResponseEntity.ok().build();
    }
}
