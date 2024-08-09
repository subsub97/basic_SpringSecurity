package org.example.tubesecurity.dto;

import lombok.Data;
import org.example.tubesecurity.entity.User;

@Data
public class JoinDTO {
    private String username;

    private String password;

    public User toEntity() {
        return new User(username,password);
    }
}
