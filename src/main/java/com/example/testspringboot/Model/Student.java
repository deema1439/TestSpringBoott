package com.example.testspringboot.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {


    @NotEmpty(message = "id Should not Be Empty")
    @Size(min = 2,message = "id Should be at least 2 ")
    private String id;

    @NotEmpty(message = "name Should not Be Empty")
    @Size(min = 3,max = 15, message = "name should be between 3 and 15")
    private String name;


    @NotNull(message = "age Should not be Empty")
    @Min(value = 5,message = "min age should be 5 years")
    private Integer age;


    @NotEmpty(message = "major should not be Empty ")
    private String major;















}
