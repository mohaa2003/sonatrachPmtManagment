package com.app.sonatrach.controllers.APIs;

import com.app.sonatrach.dto.ProfilDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface ProfilApi {
   @CrossOrigin(origins = "http://localhost:3000")
   ResponseEntity<ProfilDto> save(ProfilDto profilDto);
   @CrossOrigin(origins = "http://localhost:3000")
   ResponseEntity<ProfilDto> findById(Integer id);
   @CrossOrigin(origins = "http://localhost:3000")
   ResponseEntity<List<ProfilDto>> findAll();
   @CrossOrigin(origins = "http://localhost:3000")
   ResponseEntity delete(Integer id);

}
