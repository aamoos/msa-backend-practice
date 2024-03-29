package com.msabackend.practice.dto.axios;

import com.msabackend.practice.entity.Axios;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

public class AxiosListDto {
    @Data
    public static class Request {
        private String title;
    }

    //노출할 것만
    @Data
    public static class Response {
        private Long id;
        private String title;
        private String body;

        public Response(Axios axios) {
            this.id = axios.getId();
            this.title = axios.getTitle();
            this.body = axios.getBody();
        }

        @QueryProjection
        public Response(Long id, String title, String body) {
           this.id = id;
           this.title = title;
           this.body = body;
        }

    }
}
