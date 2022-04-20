package com.example.chatappbe.Controllers;

import com.example.chatappbe.Models.DTOs.RegistrationDTO;
import com.example.chatappbe.Models.Message;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/")
public class UserController {

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegistrationDTO registrationDTO){

        if (registrationDTO.getUsername() == null
        || registrationDTO.getEmail() == null
        || registrationDTO.getPassword() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Message("Please fill all the fields!"));
        }
        else if (registrationDTO.getUsername().length() < 3){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Message("Username needs to have at least 3 characters!"));
        }
        else if (!(registrationDTO.getUsername().matches("[a-zA-Z]*"))){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Message("Username needs to start with a letter!"));
        }
        else if (registrationDTO.getPassword().length() < 8){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Message("Passwords needs to have length of at least 8 characters"));
        }
        else if (!(registrationDTO.getPassword().matches("(.*)[0-9](.*)"))){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Message("Passwords needs to contain a number!"));
        }
        else if (!(registrationDTO.getEmail()
                .matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"))){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Message("Email is not in a correct format!"));
        }

        return null;
    }
}
