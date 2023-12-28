package com.example.warzone.repositories;

import com.example.warzone.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findAllByFollowers(int followers);

    List<Users> findAllByName(String name);

    List<Users> findAllByNickname(String nickname);

    List<Users> findAllByEmail(String email);

    List<Users> findAllByDescription(String description);

    List<Users> findAllByVisibility(String visibility);

    List<Users> findAllByAvatar(String avatar);

    List<Users> findAllByPassword(String password);
}
