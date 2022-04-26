package com.example.chatappbe.Services;

import com.example.chatappbe.Models.DTOs.RegistrationDTO;
import com.example.chatappbe.Models.ChatUser;
import com.example.chatappbe.Repositories.ChatUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChatUserServiceImpl implements ChatUserService {

    ChatUserRepository chatUserRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public String createUser(RegistrationDTO registrationDTO){

        try {
            List<ChatUser> chatUsers = chatUserRepository.findAll();

            for (int i = 0; i < chatUsers.stream().count(); i++){
                if ( chatUsers.get(i).getUsername().equals(registrationDTO.getUsername())){

                    return "Username is already in use!";
                }
                if (chatUsers.get(i).getEmail().equals(registrationDTO.getEmail())){

                    return "Email is already in use!";
                }
            }
        } catch (NullPointerException nullPointerException){

            return "Database is empty.";
        }



        String encodedPassword = passwordEncoder.encode(registrationDTO.getPassword());

        return "New User created, next confirm your email address and activate your account.";
    }
}
