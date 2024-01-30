package com.msabackend.practice.repository;

import com.msabackend.practice.entity.Axios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AxiosRepository extends JpaRepository<Axios, Integer> {

}
