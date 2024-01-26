package com.msabackend.practice.dto.users;

import com.msabackend.practice.entity.Users;
import lombok.Data;

@Data
public class UsersListDto {

    @Data
    public static class Request {
        private Long id;
        private String username;
        private int age;
    }

    //노출할 것만
    @Data
    public static class Response {
        private Long id;
        private String username;
        private int age;

        public Response(Users users) {
            this.id = users.getId();
            this.username = users.getUsername();
            this.age = users.getAge();
        }
    }
}
