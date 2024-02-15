package com.example.warzone.servises.impl;

import com.example.warzone.controllers.exceptions.UsersConflictException;
import com.example.warzone.controllers.exceptions.UsersNotFoundException;
import com.example.warzone.dtos.UsersDto;
import com.example.warzone.models.Users;
import com.example.warzone.repositories.UsersRepository;
import com.example.warzone.servises.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UsersServiceImpl implements UsersService {
    private ModelMapper modelMapper;
    UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.usersRepository = usersRepository;
    }

    @Override
    public List<UsersDto> getAll() {
        return usersRepository.findAll().stream().map((s)->modelMapper.map(s,UsersDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<UsersDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(usersRepository.findById(id),UsersDto.class));
    }

    @Override
    public UsersDto register(UsersDto usersDto) {
        Users users = modelMapper.map(usersDto,Users.class);
        if (users.getId() == null || users.getId() == 0 || get(users.getId()).isEmpty()){
            return modelMapper.map(usersRepository.save(users),UsersDto.class);
        } else {
            throw new UsersConflictException("A user with this id already exists");
        }
    }

    @Override
    public UsersDto update(UsersDto usersDto) {
        if (usersRepository.findById(usersDto.getId()).isPresent()){
            return modelMapper.map(usersRepository.save(modelMapper.map(usersDto,Users.class)),UsersDto.class);
        } else {
            throw new UsersNotFoundException(usersDto.getId());
        }
    }

    @Override
    public void delete(Long id) {
        if (usersRepository.findById(id).isPresent()){
            usersRepository.deleteById(id);
        } else {
            throw new UsersNotFoundException(id);
        }
    }
    @Override
    public List<UsersDto> findAllByFollowers(int followers) {
        return usersRepository.findAllByFollowers(followers).stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UsersDto> findAllByName(String name) {
        return usersRepository.findAllByName(name).stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UsersDto> findAllByNickname(String nickname) {
        return usersRepository.findAllByNickname(nickname).stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UsersDto> findAllByEmail(String email) {
        return usersRepository.findAllByEmail(email).stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UsersDto> findAllByDescription(String description) {
        return usersRepository.findAllByDescription(description).stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UsersDto> findAllByVisibility(String visibility) {
        return usersRepository.findAllByVisibility(visibility).stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UsersDto> findAllByAvatar(String avatar) {
        return usersRepository.findAllByAvatar(avatar).stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UsersDto> findAllByPassword(String password) {
        return usersRepository.findAllByPassword(password).stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }
}
