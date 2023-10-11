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
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    private ModelMapper modelMapper;
    public UsersServiceImpl(UsersRepository usersRepository){
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
}
