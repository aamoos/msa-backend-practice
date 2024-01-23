package com.msabackend.practice.repository;

import com.msabackend.practice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<Users, Integer> {
}
