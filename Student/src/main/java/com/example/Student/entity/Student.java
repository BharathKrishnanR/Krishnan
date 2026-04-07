package com.example.Student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;


@Entity
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 20,message = "First name Should be 3 to 20 Character")
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 20,message="Last name Should be 3 to 20 Character")
    private String lastName;

    @NotBlank
    @Email(message="email format is wrong  ")
    private String email;

}
