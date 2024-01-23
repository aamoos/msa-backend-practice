package com.msabackend.practice.service;

import com.msabackend.practice.repository.ApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class ApiService {

    private final ApiRepository apiRepository;



}
