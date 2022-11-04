package com.vizsgafeladat.service;

import com.vizsgafeladat.dto.UserCreateCommand;
import com.vizsgafeladat.dto.UserDetailsDto;
import com.vizsgafeladat.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toEntity(UserCreateCommand command);
    UserDetailsDto toDto(User user);
}
