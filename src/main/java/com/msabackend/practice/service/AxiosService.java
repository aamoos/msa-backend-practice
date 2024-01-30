package com.msabackend.practice.service;

import com.msabackend.practice.dto.Result;
import com.msabackend.practice.dto.axios.AxiosListDto;
import com.msabackend.practice.dto.axios.AxiosSaveDto;
import com.msabackend.practice.dto.axios.QAxiosListDto_Response;
import com.msabackend.practice.entity.Axios;
import com.msabackend.practice.repository.AxiosRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.msabackend.practice.entity.QAxios.axios;

@RequiredArgsConstructor
@Service
@Transactional
public class AxiosService {

    private final AxiosRepository axiosRepository;
    private final JPAQueryFactory jpaQueryFactory;

    // axios - 리스트 조회
    @Transactional(readOnly = true)
    public Result list(){
        List<Axios> axios = axiosRepository.findAll();

        List<AxiosListDto.Response> resultDto = axios.stream()
                .map(AxiosListDto.Response::new)
                .collect(Collectors.toList());

        return new Result(resultDto.size(), resultDto);
    }

    //axios - 검색어 조회
    @Transactional(readOnly = true)
    public Result search(String title){
        List<AxiosListDto.Response> resultDto = searchByTitleList(title);

        return new Result(resultDto.size(), resultDto);
    }

    //검색어가 있을수도 있고, 없을수도 있으므로, querydsl 동적쿼리를 사용해서 구현한다.
    public List<AxiosListDto.Response> searchByTitleList(String title){
        return jpaQueryFactory
                .select(new QAxiosListDto_Response(
                    axios.id,
                    axios.title,
                    axios.body
                ))
                .from(axios)
                .where(
                    titleLike(title)
                )
                .fetch();
    }

    //axios - 저장
    public AxiosSaveDto.Response save(AxiosSaveDto.Request request){
        return new AxiosSaveDto.Response( axiosRepository.save(request.toEntity()).getId() );
    }

    //axios - 삭제
    public void delete(int id){
        axiosRepository.deleteById(id);
    }

    //검색 title like 조건
    private BooleanExpression titleLike(String title){
        return StringUtils.hasText(title) ? axios.title.contains(title) : null;
    }

}
