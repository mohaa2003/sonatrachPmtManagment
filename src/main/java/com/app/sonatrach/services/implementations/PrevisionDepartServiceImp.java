package com.app.sonatrach.services.implementations;

import com.app.sonatrach.dto.InactiveEmployeDto;
import com.app.sonatrach.dto.PMTDto;
import com.app.sonatrach.dto.PrevisionDepartDto;
import com.app.sonatrach.dto.UserDto;
import com.app.sonatrach.exceptions.EntityNotFoundException;
import com.app.sonatrach.exceptions.ErrorCodes;
import com.app.sonatrach.exceptions.InvalidEntityException;
import com.app.sonatrach.model.PMT;
import com.app.sonatrach.model.PrevisionDepart;
import com.app.sonatrach.repositories.PrevisionDepartRepo;
import com.app.sonatrach.services.PrevisionDepartService;
import com.app.sonatrach.validators.InactiveEmployeValidator;
import com.app.sonatrach.validators.PrevisionDepartValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PrevisionDepartServiceImp implements PrevisionDepartService {

    private PrevisionDepartRepo previsionDepartRepo;

    @Autowired
    public PrevisionDepartServiceImp(PrevisionDepartRepo previsionDepartRepo) {
        this.previsionDepartRepo = previsionDepartRepo;
    }

    @Override
    public PrevisionDepartDto save(PrevisionDepartDto previsionDepartDto) {
        List<String> errors = PrevisionDepartValidator.validate(previsionDepartDto);
        if(!previsionDepartDto.getPmtDto().isCurrentYear()){
            errors.add("On peut ajouter , modifier et supprimer les prevision du cette annee seulement");
        }
        if(!errors.isEmpty()){
            log.error("Prevision not valid",previsionDepartDto);
            throw new InvalidEntityException("Prevision non valide", ErrorCodes.PREVISION_DEPART_NOT_VALID,errors);
        }
        return PrevisionDepartDto.fromEntity(previsionDepartRepo.save(PrevisionDepartDto.toEntity(previsionDepartDto)));
    }

    @Override
    public PrevisionDepartDto findById(Integer id) {
        if(id == null){
            log.error("prevision non valide");
            return null;
        }
        Optional<PrevisionDepart> previsionDepart = previsionDepartRepo.findById(id);
        return Optional.of(PrevisionDepartDto.fromEntity(previsionDepart.get()))
                .orElseThrow(() -> new EntityNotFoundException("Aucune prevision est trouve avec l'id "+id+" dans la base de donnees",ErrorCodes.PREVISION_DEPART_NOT_FOUND));
    }

    @Override
    public List<PrevisionDepartDto> findAll() {
        return previsionDepartRepo.findAll().stream()
                .map(PrevisionDepartDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void confirmDepart(Integer id) {
        if(id == null){
            log.error("prevision pas valide");
        }
        previsionDepartRepo.confirmDepart(id);
    }

    @Override
    public void inconfirmDepart(Integer id) {
        if(id == null){
            log.error("prevision pas valide");
        }
        previsionDepartRepo.inconfirmDepart(id);
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("prevision pas valide");
        }
        previsionDepartRepo.deleteById(id);

    }
}
