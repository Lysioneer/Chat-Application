package com.example.chatappbe.Models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationDTO {

    private String username;

    private String email;

    private String password;
}
