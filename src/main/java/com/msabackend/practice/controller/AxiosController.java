package com.msabackend.practice.controller;

import com.msabackend.practice.dto.Result;
import com.msabackend.practice.dto.axios.AxiosSaveDto;
import com.msabackend.practice.service.AxiosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/axios")
@RequiredArgsConstructor
public class AxiosController {
    private final AxiosService axiosService;

    // 리스트 조회
    @GetMapping(value = "/list")
    public Result list(){
        return axiosService.list();
    }

    // 저장
    @PostMapping(value = "/save")
    public AxiosSaveDto.Response save(@RequestBody AxiosSaveDto.Request request){
        return axiosService.save(request);
    }
}
