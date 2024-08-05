package com.app.sonatrach.repositories;

import com.app.sonatrach.model.PrevisionDepart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PrevisionDepartRepo extends JpaRepository<PrevisionDepart,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE PrevisionDepart p SET p.isConfirmed = true WHERE p.id = :previsionId AND p.isConfirmed = false")
    void confirmDepart(@Param("previsionId") Integer previsionId);

    @Modifying
    @Transactional
    @Query("UPDATE PrevisionDepart p SET p.isConfirmed = false WHERE p.id = :previsionId AND p.isConfirmed = true")
    void inconfirmDepart(@Param("previsionId") Integer previsionId);
}
