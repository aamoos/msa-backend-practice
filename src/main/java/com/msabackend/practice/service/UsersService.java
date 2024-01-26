package com.msabackend.practice.service;

import com.msabackend.practice.dto.Result;
import com.msabackend.practice.dto.users.UsersListDto;
import com.msabackend.practice.entity.Users;
import com.msabackend.practice.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class UsersService {

    private final UsersRepository usersRepository;

    //사용자 리스트 - 조회
    public Result list(){
        List<Users> users = usersRepository.findAll();

        List<UsersListDto.Response> resultDto = users.stream()
                .map(UsersListDto.Response::new)
                .collect(Collectors.toList());

        return new Result(resultDto.size(), resultDto);
    }

}
