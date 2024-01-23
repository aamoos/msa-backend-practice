package com.msabackend.practice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {

    // Model Mapper
    // DT- <-> Entity Type Change
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
