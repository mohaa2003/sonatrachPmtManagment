package com.app.sonatrach.services.implementations;

import com.app.sonatrach.dto.CSPDto;
import com.app.sonatrach.dto.EmployeDto;
import com.app.sonatrach.dto.ProfilDto;
import com.app.sonatrach.dto.UserDto;
import com.app.sonatrach.exceptions.EntityNotFoundException;
import com.app.sonatrach.exceptions.ErrorCodes;
import com.app.sonatrach.exceptions.InvalidEntityException;
import com.app.sonatrach.model.CSP;
import com.app.sonatrach.model.User;
import com.app.sonatrach.repositories.ActivityRepo;
import com.app.sonatrach.repositories.CSPRepo;
import com.app.sonatrach.services.CSPService;
import com.app.sonatrach.validators.CSPValidator;
import com.app.sonatrach.validators.ProfilValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CSPServiceImp implements CSPService {
    @Autowired
    private CSPRepo cspRepo;
    @Override
    public CSPDto save(CSPDto cspDto) {
        List<String> errors = CSPValidator.validate(cspDto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("csp non valide", ErrorCodes.PROFIL_NOT_VALID, errors);
        }
        return CSPDto.fromEntity(cspRepo.save(CSPDto.toEntity(cspDto)));

    }

    @Override
    public CSPDto findById(Integer id) {
        if(id == null){
            log.error("csp non valide");
            return null;
        }
        Optional<CSP> csp = cspRepo.findById(id);
        return Optional.of(CSPDto.fromEntity(csp.get()))
                .orElseThrow(() -> new EntityNotFoundException("Aucun csp est trouve avec l'id "+id+" dans la base de donnees", ErrorCodes.CSP_NOT_FOUND));

    }

    @Override
    public List<CSPDto> findAll() {

        return cspRepo.findAll().stream()
                .map(CSPDto::fromEntity).collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("CSP not valide");
        }
        cspRepo.deleteById(id);

    }
}
