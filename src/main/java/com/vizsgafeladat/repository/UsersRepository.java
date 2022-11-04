package com.vizsgafeladat.repository;

import com.vizsgafeladat.dto.UserDto;
import com.vizsgafeladat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<User,Long> {

    @Query("select new com.vizsgafeladat.dto.UserDto(e.id, e.userEmail) from User e")
    List<UserDto> findUserDtos();

    @Query("select new com.vizsgafeladat.dto.UserDto(e.id, e.userEmail) from User e where e.userEmail like :prefix")
    List<UserDto> findUserDtosByNameLike(String prefix);

}
