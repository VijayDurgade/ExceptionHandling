package com.exceptionhandling.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "User name should not be null")
    private String name;
    @Email(message = "Invalid email address")
    private String email;
    @NotNull
    @Pattern(regexp = "^\\d{10}$",message = "Entered mobile number is invalid")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;
}
