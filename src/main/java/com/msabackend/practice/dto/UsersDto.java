package com.msabackend.practice.dto;

import com.msabackend.practice.entity.Users;
import lombok.Data;
import lombok.Getter;

@Data
public class UsersDto {

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

    @Getter
    public static class Response {
        private Long id;

        public Response(Users users){
            this.id = users.getId();
        }
    }

}
