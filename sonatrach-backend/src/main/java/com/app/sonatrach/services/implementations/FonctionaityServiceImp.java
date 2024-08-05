package com.app.sonatrach.services.implementations;

import com.app.sonatrach.dto.EmployeDto;
import com.app.sonatrach.dto.FonctionalityDto;
import com.app.sonatrach.dto.ProfilDto;
import com.app.sonatrach.dto.UserDto;
import com.app.sonatrach.exceptions.EntityNotFoundException;
import com.app.sonatrach.exceptions.ErrorCodes;
import com.app.sonatrach.exceptions.InvalidEntityException;
import com.app.sonatrach.model.Fonctionality;
import com.app.sonatrach.model.User;
import com.app.sonatrach.repositories.CSPRepo;
import com.app.sonatrach.repositories.FonctionalityRepo;
import com.app.sonatrach.services.FonctionaityService;
import com.app.sonatrach.validators.FonctionnalityValidator;
import com.app.sonatrach.validators.ProfilValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FonctionaityServiceImp implements FonctionaityService {
    @Autowired
    private FonctionalityRepo fonctionalityRepo;
    @Override
    public FonctionalityDto save(FonctionalityDto fonctionalityDto) {
        List<String> errors = FonctionnalityValidator.validate(fonctionalityDto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("fonctionality non valide", ErrorCodes.FONCTIONALITY_NOT_VALID, errors);
        }
        return FonctionalityDto.fromEntity(fonctionalityRepo.save(FonctionalityDto.toEntity(fonctionalityDto)));

    }

    @Override
    public FonctionalityDto findById(Integer id) {

        if(id == null){
            log.error("fonction non valide");
            return null;
        }
        Optional<Fonctionality> fonctionality = fonctionalityRepo.findById(id);
        return Optional.of(FonctionalityDto.fromEntity(fonctionality.get()))
                .orElseThrow(() -> new EntityNotFoundException("Aucun fonction est trouve avec l'id "+id+" dans la base de donnees", ErrorCodes.FONCTIONALITY_NOT_FOUND));

    }

    @Override
    public List<FonctionalityDto> findAll() {
        return fonctionalityRepo.findAll().stream()
                .map(FonctionalityDto::fromEntity).collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("fonction not valide");
        }
        fonctionalityRepo.deleteById(id);

    }
}
