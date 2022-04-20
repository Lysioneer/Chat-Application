package com.example.chatappbe.Repositories;

import com.example.chatappbe.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
