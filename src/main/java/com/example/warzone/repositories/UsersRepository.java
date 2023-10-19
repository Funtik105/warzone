package com.example.warzone.repositories;

import com.example.warzone.models.Attachments;
import com.example.warzone.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findAllByFollowers(int followers);
}
