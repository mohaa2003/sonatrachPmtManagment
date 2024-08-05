package com.app.sonatrach.services.implementations;

import com.app.sonatrach.dto.*;
import com.app.sonatrach.exceptions.EntityNotFoundException;
import com.app.sonatrach.exceptions.ErrorCodes;
import com.app.sonatrach.exceptions.InvalidEntityException;
import com.app.sonatrach.model.Profil;
import com.app.sonatrach.model.User;
import com.app.sonatrach.repositories.CSPRepo;
import com.app.sonatrach.repositories.ProfilRepo;
import com.app.sonatrach.services.ProfilService;
import com.app.sonatrach.validators.ProfilValidator;
import com.app.sonatrach.validators.StructureValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProfilServiceImp implements ProfilService {
    @Autowired
    private ProfilRepo profilRepo;
    @Override
    public ProfilDto save(ProfilDto profilDto) {
        List<String> errors = ProfilValidator.validate(profilDto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("profil non valide", ErrorCodes.PROFIL_NOT_VALID, errors);
        }
        return ProfilDto.fromEntity(profilRepo.save(ProfilDto.toEntity(profilDto)));

    }

    @Override
    public ProfilDto findById(Integer id) {

        if(id == null){
            log.error("profil non valide");
            return null;
        }
        Optional<Profil> profil = profilRepo.findById(id);
        return Optional.of(ProfilDto.fromEntity(profil.get()))
                .orElseThrow(() -> new EntityNotFoundException("Aucun profil est trouve avec l'id "+id+" dans la base de donnees", ErrorCodes.EMPLOYE_NOT_FOUND));

    }

    @Override
    public List<ProfilDto> findAll() {

        return profilRepo.findAll().stream()
                .map(ProfilDto::fromEntity).collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("profil not valide");
        }
        profilRepo.deleteById(id);

    }
}
