package com.example.warzone.servises;

import com.example.warzone.dtos.UsersDto;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<UsersDto> getAll();
    Optional<UsersDto> get(Long id);
    UsersDto register(UsersDto usersDto);
    UsersDto update(UsersDto usersDto);
    void delete(Long id);
    List<UsersDto> findAllByFollowers(int followers);

}
