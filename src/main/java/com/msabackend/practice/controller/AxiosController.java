package com.msabackend.practice.controller;

import com.msabackend.practice.dto.Result;
import com.msabackend.practice.dto.axios.AxiosSaveDto;
import com.msabackend.practice.service.AxiosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/axios")
@RequiredArgsConstructor
public class AxiosController {
    private final AxiosService axiosService;

    // 리스트 조회
    @GetMapping(value = "/list")
    public ResponseEntity<Result> list(){
        return ResponseEntity.ok()
                .body(axiosService.list());
    }

    // 등록
    @PostMapping(value = "/create")
    public ResponseEntity<AxiosSaveDto.Response> save(@RequestBody AxiosSaveDto.Request request){
        return ResponseEntity.ok()
                .body(axiosService.save(request));
    }

    //삭제
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){

    }


}
