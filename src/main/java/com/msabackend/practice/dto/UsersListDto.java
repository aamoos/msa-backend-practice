package com.msabackend.practice.dto;

import com.msabackend.practice.entity.Users;
import lombok.Data;

@Data
public class UsersListDto {

    @Data
    public static class Request {
        private Long id;
        private String username;
        private int age;

        /* Dto -> Entity */
        public Users toEntity(){
            return Users.builder()
                    .id(id)
                    .username(username)
                    .age(age)
                    .build();
        }
    }

    //노출할 것만
    @Data
    public static class Response {
        private Long id;
        private String username;
        private int age;
    }
}
