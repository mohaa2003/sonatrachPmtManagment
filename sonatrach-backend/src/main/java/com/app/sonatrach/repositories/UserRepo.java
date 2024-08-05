package com.app.sonatrach.repositories;

import com.app.sonatrach.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
