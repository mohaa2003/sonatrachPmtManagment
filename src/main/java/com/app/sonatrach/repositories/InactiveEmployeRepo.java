package com.app.sonatrach.repositories;

import com.app.sonatrach.model.InactiveEmploye;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InactiveEmployeRepo extends JpaRepository<InactiveEmploye,Integer> {
}
