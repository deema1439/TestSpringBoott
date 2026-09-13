package com.example.testspringboot.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotEmpty(message = "id Should not Be Empty")
    @Size(min = 2,message = "id Should be at least 2 ")
    private String id;

    @NotEmpty(message = "name Should not Be Empty")
    @Size(min = 3,max = 15, message = "name should be between 3 and 15")
    private String name;

    @NotNull(message = "Salary Should not be empty")
    private Double Salary;























}
