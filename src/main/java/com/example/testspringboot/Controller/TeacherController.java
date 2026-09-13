package com.example.testspringboot.Controller;

import com.example.testspringboot.Api.ApiResponse;
import com.example.testspringboot.Model.Teacher;
import com.example.testspringboot.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity<?>getTeacher(){
        ArrayList<Teacher>getTeachers=teacherService.getTeachers();
        return ResponseEntity.status(200).body(getTeachers);
    }


    @PostMapping("/add")
    public ResponseEntity<?>addTeacher(@Valid @RequestBody Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher has been added"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateTeacher(@PathVariable String id,@Valid @RequestBody Teacher teacher,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean UpdateTeacher=teacherService.UpdateTeacher(id,teacher);
       if(!UpdateTeacher){
           return ResponseEntity.status(400).body(new ApiResponse("id not Found"));
       }
       return ResponseEntity.status(200).body(new ApiResponse("Teacher has been Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteTeacher(@PathVariable String id){
        boolean deleteTeacher=teacherService.deleteTeacher(id);
        if(!deleteTeacher){
            return ResponseEntity.status(400).body(new ApiResponse("id not found"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("teacher has been deleted"));
    }

    @GetMapping("/getbyteacherid/{id}")
    public ResponseEntity<?>getTeacherById(@PathVariable String id ){
        Teacher getTeacherId=teacherService.getTeacherId(id);
        if(getTeacherId==null){
            return ResponseEntity.status(400).body(new ApiResponse("not found"));
        }
        return ResponseEntity.status(200).body(getTeacherId);
    }

    @GetMapping("/getbysalary/{salary}")
    public ResponseEntity<?>getTeacherBySalary(@PathVariable Double salary){
        ArrayList<Teacher>getSalary=teacherService.getSalary(salary);
        if(getSalary.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponse("Theres not teachers with this Salary"));
        }
        return ResponseEntity.status(200).body(getSalary);
    }













}
