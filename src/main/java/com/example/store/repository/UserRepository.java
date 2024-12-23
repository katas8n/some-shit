package com.example.store.repository;

import com.example.store.model.UserDemo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserDemo, Long> {
}
