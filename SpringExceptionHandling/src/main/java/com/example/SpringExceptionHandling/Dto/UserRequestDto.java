package com.example.SpringExceptionHandling.Dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequestDto {
    //    Below request comes from frontend application / postman
    private int userId;
    @NotNull(message = "User Name should not be null")
    @NotBlank
    private String name;
    @Email(message = "invalid email address")
    private String email;
    @NotNull
//    \d means a range of digits (0-9)
//    \d{10} means you should have 10 characters matching any decimal digit (including [0-9]

    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered")
    private String mobile;
    private String gender;

    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;

}
