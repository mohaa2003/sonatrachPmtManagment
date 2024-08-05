package com.app.sonatrach.repositories;

import com.app.sonatrach.model.PMT;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface PMTRepo extends JpaRepository<PMT,Integer> {
}
