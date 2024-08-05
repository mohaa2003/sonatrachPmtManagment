package com.app.sonatrach.repositories;

import com.app.sonatrach.dto.ActivityDto;
import com.app.sonatrach.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepo extends JpaRepository<Activity,Integer> {

}
