package com.example.chatappbe;

import com.example.chatappbe.Models.ChatUser;
import com.example.chatappbe.Repositories.ChatUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@AllArgsConstructor
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ChatAppBeApplication implements CommandLineRunner {

    private final BCryptPasswordEncoder encoder;
    private final ChatUserRepository chatUserRepository;

    private void dummyData(){

        chatUserRepository.save(new ChatUser("Hanz", "hanz@gmail.com", encoder.encode("password"), false, LocalDateTime.now()));
        chatUserRepository.save(new ChatUser("Hanz2", "hanz2@gmail.com", encoder.encode("password2"), false, LocalDateTime.now()));
        chatUserRepository.save(new ChatUser("Hanz3", "hanz3@gmail.com", encoder.encode("password3"), true, LocalDateTime.now()));
        chatUserRepository.save(new ChatUser("Hanz4", "hanz@gmail.com", encoder.encode("password4"), false, LocalDateTime.now()));
        chatUserRepository.save(new ChatUser("Hanz5", "hanz@gmail.com", encoder.encode("password5"), true, LocalDateTime.now()));
    }

    public static void main(String[] args) {
        SpringApplication.run(ChatAppBeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //dummyData();      // <---- Uncomment this for adding sample data
    }
}
