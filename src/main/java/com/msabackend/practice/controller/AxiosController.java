package com.msabackend.practice.controller;

import com.msabackend.practice.dto.Result;
import com.msabackend.practice.dto.axios.AxiosListDto;
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

    //리스트 검색 조회
    @GetMapping(value = "/search")
    public ResponseEntity<Result> search(@RequestParam(value = "title") String title){
        return ResponseEntity.ok()
                .body(axiosService.search(title));
    }

    // 등록
    @PostMapping(value = "/create")
    public ResponseEntity<AxiosSaveDto.Response> insert(@RequestBody AxiosSaveDto.Request request){
        return ResponseEntity.ok()
                .body(axiosService.save(request));
    }

    //수정
    @PutMapping(value = "/update")
    public ResponseEntity<AxiosSaveDto.Response> update(@RequestBody AxiosSaveDto.Request request){
        return ResponseEntity.ok()
                .body(axiosService.save(request));
    }


    //삭제
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") int id){
        axiosService.delete(id);
    }


}
