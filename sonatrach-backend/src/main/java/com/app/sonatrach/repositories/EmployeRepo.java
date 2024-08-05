package com.app.sonatrach.repositories;

import com.app.sonatrach.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepo extends JpaRepository<Employe,Integer> {
}
