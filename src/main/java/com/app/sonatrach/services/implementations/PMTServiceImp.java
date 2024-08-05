package com.app.sonatrach.services.implementations;

import com.app.sonatrach.dto.*;
import com.app.sonatrach.exceptions.EntityNotFoundException;
import com.app.sonatrach.exceptions.ErrorCodes;
import com.app.sonatrach.exceptions.InvalidEntityException;
import com.app.sonatrach.model.Employe;
import com.app.sonatrach.model.InactiveEmploye;
import com.app.sonatrach.model.PMT;
import com.app.sonatrach.model.PrevisionDepart;
import com.app.sonatrach.repositories.EmployeRepo;
import com.app.sonatrach.repositories.InactiveEmployeRepo;
import com.app.sonatrach.repositories.PMTRepo;
import com.app.sonatrach.repositories.PrevisionDepartRepo;
import com.app.sonatrach.services.PMTService;
import com.app.sonatrach.validators.InactiveEmployeValidator;
import com.app.sonatrach.validators.PMTValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@Slf4j
public class PMTServiceImp implements PMTService {
    private PMTRepo pmtRepo;
    private EmployeRepo employeRepo;
    private PrevisionDepartRepo previsionDepartRepo;
    @Autowired
    public PMTServiceImp(PMTRepo pmtRepo,EmployeRepo employeRepo,PrevisionDepartRepo previsionDepartRepo){
        this.pmtRepo = pmtRepo;
        this.employeRepo = employeRepo;
        this.previsionDepartRepo = previsionDepartRepo;
    }

    @Override
    public PMTDto save(PMTDto pmtDto) {

        List<String> errors = PMTValidator.validate(pmtDto);
        if(!pmtDto.isCurrentYear()) {
            errors.add("On peut ajouter , modifier et supprimer le pmt du cette annee seulement");
        }
        if (!errors.isEmpty()) {
            log.error("pmt not valid", pmtDto);
            throw new InvalidEntityException("pmt non valide", ErrorCodes.PMT_NOT_VALID, errors);
        }
        // Récupérer tous les employés actifs
        List<Employe> allEmployes = employeRepo.findAll();

        // Filtrer les employés actifs
        List<EmployeDto> employesActifs = allEmployes.stream()
                .filter(employe -> !employe.getDesactive()).map(EmployeDto::fromEntity)
                .collect(Collectors.toList());

        // Date actuelle
        LocalDate dateActuelle = LocalDate.now();

        // Parcourir tous les employés
        for (EmployeDto employeDto : employesActifs) {
            // Convertir dateDeNaissance (Instant) en LocalDate
            LocalDate dateDeNaissance = employeDto.getDateNaissance().atZone(ZoneId.systemDefault()).toLocalDate();
            // Calculer la date où l'employé aura 60 ans
            LocalDate date60Ans = dateDeNaissance.plusYears(60);

            // Vérifier si cette date est dans les 4 prochaines années
            if (date60Ans.isAfter(dateActuelle) && date60Ans.isBefore(dateActuelle.plusYears(4))) {
                // Créer une prévision de départ pour cet employé
                PrevisionDepartDto previsionDepartDto = new PrevisionDepartDto();
                previsionDepartDto.setEmployeDto(employeDto);

                // Convertir le 1er jour de l'année où l'employé atteint 60 ans en Instant
                LocalDate premierJourAnnee60Ans = LocalDate.of(date60Ans.getYear(), 1, 1);
                Instant premierJourAnnee60AnsInstant = premierJourAnnee60Ans.atStartOfDay(ZoneId.systemDefault()).toInstant();
                previsionDepartDto.setAnnee(premierJourAnnee60AnsInstant);
                previsionDepartDto.setPmtDto(PMTDto.fromEntity(pmtRepo.save(PMTDto.toEntity(pmtDto))));
                previsionDepartDto.setObservation("");

                // Enregistrer la prévision de départ
                previsionDepartRepo.save(PrevisionDepartDto.toEntity(previsionDepartDto));
            }
        }
        return PMTDto.fromEntity(pmtRepo.save(PMTDto.toEntity(pmtDto)));
    }

    @Override
    public PMTDto findById(Integer id) {
        if(id == null){
            log.error("pmt non valide");
            return null;
        }
        Optional<PMT> pmt = pmtRepo.findById(id);
        return Optional.of(PMTDto.fromEntity(pmt.get()))
                .orElseThrow(() -> new EntityNotFoundException("Aucun pmt est trouve avec l'id "+id+" dans la base de donnees",ErrorCodes.PMT_NOT_FOUND));
    }

    @Override
    public List<PMTDto> findAll() {
        return pmtRepo.findAll().stream()
                .map(PMTDto::fromEntity).collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {

        if(id == null){
            log.error("PMT not valide");
        }
        pmtRepo.deleteById(id);

    }
}
