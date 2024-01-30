package com.msabackend.practice.service;

import com.msabackend.practice.dto.Result;
import com.msabackend.practice.dto.axios.AxiosListDto;
import com.msabackend.practice.dto.axios.AxiosSaveDto;
import com.msabackend.practice.entity.Axios;
import com.msabackend.practice.repository.AxiosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class AxiosService {

    private final AxiosRepository axiosRepository;

    // axios - 리스트 조회
    @Transactional(readOnly = true)
    public Result list(AxiosListDto.Request request){
        List<Axios> axios = axiosRepository.findAll();

        List<AxiosListDto.Response> resultDto = axios.stream()
                .map(AxiosListDto.Response::new)
                .collect(Collectors.toList());

        return new Result(resultDto.size(), resultDto);
    }

    //axios - 저장
    public AxiosSaveDto.Response save(AxiosSaveDto.Request request){
        return new AxiosSaveDto.Response( axiosRepository.save(request.toEntity()).getId() );
    }

    //axios - 삭제
    public void delete(int id){
        axiosRepository.deleteById(id);
    }
}
