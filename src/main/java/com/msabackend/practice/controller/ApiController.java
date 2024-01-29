package com.msabackend.practice.controller;

import com.msabackend.practice.dto.Result;
import com.msabackend.practice.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
public class ApiController {

    private final UsersService usersService;

    @GetMapping(value = "/list")
    public Result list(){
        return usersService.list();
    }

}
