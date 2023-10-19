package com.exceptionhandling.repository;

import com.exceptionhandling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(int userId);
}
