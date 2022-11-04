package com.vizsgafeladat.controller;

import com.vizsgafeladat.dto.UserCreateCommand;
import com.vizsgafeladat.dto.UserDetailsDto;
import com.vizsgafeladat.dto.UserDto;
import com.vizsgafeladat.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Slf4j
public class UserController {
    private UsersService service;

    @GetMapping
    public List<UserDto> listUsers(@RequestParam("prefix") Optional<String> prefix) {
        return service.listUsers(prefix);
    }

    @PostMapping
    public ResponseEntity<UserDetailsDto> createUser(@Valid @RequestBody UserCreateCommand command,
                                                     UriComponentsBuilder uri) {
        var userDetailsDto = service.createUser(command);
        /*
        return ResponseEntity
                .created(uri.path("/api/users/{id}").buildAndExpand(userDetailsDto.getId()).toUri())
                .body(userDetailsDto);*/
    }

    //@PostMapping("{Id}/todos")
}
