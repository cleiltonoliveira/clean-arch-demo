package com.example.web.controller.student.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class StudentCreationRequest {
    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
}
