package com.app.sonatrach.controllers.APIs;

import com.app.sonatrach.dto.PrevisionDepartDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface PrevisionDepartApi {
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<PrevisionDepartDto> save(PrevisionDepartDto previsionDepartDto);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<PrevisionDepartDto> findById(Integer id);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<List<PrevisionDepartDto>> findAll();
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity confirmDepart(Integer id);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity inconfirmDepart(Integer id);
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity delete(Integer id);
}
