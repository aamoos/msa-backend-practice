package com.msabackend.practice.controller;

import com.msabackend.practice.dto.Result;
import com.msabackend.practice.dto.UsersListDto;
import com.msabackend.practice.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ApiController {

    private final UsersService usersService;

    public Result list(){
        return usersService.list();
    }

}
