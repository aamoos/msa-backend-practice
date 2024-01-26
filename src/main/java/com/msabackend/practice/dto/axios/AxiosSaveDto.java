package com.msabackend.practice.dto.axios;

import com.msabackend.practice.entity.Axios;
import lombok.Data;

public class AxiosSaveDto {
    @Data
    public static class Request {
        private Long id;
        private String title;
        private String body;

        /* Dto -> Entity */
        public Axios toEntity(){
            return Axios.builder()
                    .id(id)
                    .title(title)
                    .body(body)
                    .build();
        }
    }

    //노출할 것만
    @Data
    public static class Response {
        private Long id;

        public Response(Long id) {
            this.id = id;
        }
    }
}
