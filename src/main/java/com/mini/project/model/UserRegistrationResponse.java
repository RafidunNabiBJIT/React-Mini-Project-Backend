package com.mini.project.model;

import com.mini.project.model.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegistrationResponse {
    private String token;
    private String role;
    public UserRegistrationResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }

}
