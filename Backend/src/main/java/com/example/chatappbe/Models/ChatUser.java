package com.example.chatappbe.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class ChatUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    private Boolean active;

    private LocalDateTime creation;

    public ChatUser(String username, String email, String password, Boolean active, LocalDateTime creation) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
        this.creation = creation;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setCreation(LocalDateTime creation) {
        this.creation = creation;
    }
}
