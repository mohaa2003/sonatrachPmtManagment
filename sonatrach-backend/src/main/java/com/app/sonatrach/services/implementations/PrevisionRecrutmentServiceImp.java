package com.app.sonatrach.services.implementations;

import com.app.sonatrach.dto.PrevisionDepartDto;
import com.app.sonatrach.dto.PrevisionRecrutmentDto;
import com.app.sonatrach.dto.UserDto;
import com.app.sonatrach.exceptions.EntityNotFoundException;
import com.app.sonatrach.exceptions.ErrorCodes;
import com.app.sonatrach.exceptions.InvalidEntityException;
import com.app.sonatrach.model.PrevisionDepart;
import com.app.sonatrach.model.PrevisionRecrutment;
import com.app.sonatrach.repositories.PrevisionDepartRepo;
import com.app.sonatrach.repositories.PrevisionRecrutmentRepo;
import com.app.sonatrach.services.PrevisionRecrutmentService;
import com.app.sonatrach.validators.PrevisioRecrutmentValidator;
import com.app.sonatrach.validators.PrevisionDepartValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PrevisionRecrutmentServiceImp implements PrevisionRecrutmentService {
    private PrevisionRecrutmentRepo previsionRecrutmentRepo;
    @Autowired
    public PrevisionRecrutmentServiceImp(PrevisionRecrutmentRepo previsionRecrutmentRepo) {
        this.previsionRecrutmentRepo = previsionRecrutmentRepo;
    }

    @Override
    public PrevisionRecrutmentDto save(PrevisionRecrutmentDto previsionRecrutmentDto) {
        List<String> errors = PrevisioRecrutmentValidator.validate(previsionRecrutmentDto);
        if(!previsionRecrutmentDto.getPmtDto().isCurrentYear()){
            errors.add("On peut ajouter , modifier et supprimer les prevision du cette annee seulement");
        }
        if(!errors.isEmpty()){
            log.error("Prevision not valid",previsionRecrutmentDto);
            throw new InvalidEntityException("Prevision non valide", ErrorCodes.PREVISION_RECRUTMENT_NOT_VALID,errors);
        }
        return PrevisionRecrutmentDto.fromEntity(previsionRecrutmentRepo.save(PrevisionRecrutmentDto.toEntity(previsionRecrutmentDto)));

    }

    @Override
    public PrevisionRecrutmentDto findById(Integer id) {
        if(id == null){
            log.error("prevision non valide");
            return null;
        }
        Optional<PrevisionRecrutment> previsionRecrutment = previsionRecrutmentRepo.findById(id);
        return Optional.of(PrevisionRecrutmentDto.fromEntity(previsionRecrutment.get()))
                .orElseThrow(() -> new EntityNotFoundException("Aucune prevision est trouve avec l'id "+id+" dans la base de donnees", ErrorCodes.PREVISION_RECRUTMENT_NOT_FOUND));

    }

    @Override
    public List<PrevisionRecrutmentDto> findAll() {
        return previsionRecrutmentRepo.findAll().stream()
                .map(PrevisionRecrutmentDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("prevision pas valide");
        }
        previsionRecrutmentRepo.deleteById(id);


    }
}
