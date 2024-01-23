package com.msabackend.practice.service;

import com.msabackend.practice.dto.Result;
import com.msabackend.practice.dto.UsersListDto;
import com.msabackend.practice.entity.Users;
import com.msabackend.practice.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class UsersService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public Result list(){
        List<Users> users = usersRepository.findAll();

        List<UsersListDto.Response> resultDto = users.stream()
                .map(data -> modelMapper.map(data, UsersListDto.Response.class))
                .collect(Collectors.toList());

        return new Result(resultDto.size(), resultDto);
    }

}
