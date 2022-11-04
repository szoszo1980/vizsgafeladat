package com.vizsgafeladat.service;

import com.vizsgafeladat.dto.UserCreateCommand;
import com.vizsgafeladat.dto.UserDetailsDto;
import com.vizsgafeladat.dto.UserDto;
import com.vizsgafeladat.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UsersService {

    private UsersRepository repository;

    UserMapper userMapper;
    public List<UserDto> listUsers(Optional<String> prefix) {

        if (prefix.isEmpty()){
            return repository.findUserDtos();
        }
        else{
            return repository.findUserDtosByNameLike(prefix.get().toLowerCase() + "%");
        }
    }

    public UserDetailsDto createUser(UserCreateCommand command) {

        var user = userMapper.toEntity(command);
        repository.save(user);
        return userMapper.toDto(user);
    }
}
