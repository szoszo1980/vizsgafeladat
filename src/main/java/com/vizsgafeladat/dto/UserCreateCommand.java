package com.vizsgafeladat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateCommand {

    @Email
    @NotBlank
    private String userEmail;

}
