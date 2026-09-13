package com.example.testspringboot.Controller;

import com.example.testspringboot.Api.ApiResponse;
import com.example.testspringboot.Model.Student;
import com.example.testspringboot.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
   private final StudentService studentService;

   @GetMapping("/get")
   public ResponseEntity<?>getStudent(){
       ArrayList<Student>getStudents=studentService.getStudents();
       return ResponseEntity.status(200).body(getStudents);
   }

   @PostMapping("/add")
   public ResponseEntity<?>addStudent(@Valid @RequestBody Student student, Errors errors){
       if(errors.hasErrors()){
           String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(message);
       }
       studentService.addStudent(student);

       return ResponseEntity.status(200).body(new ApiResponse("student has been added"));

   }


   @PutMapping("/update/{id}")
   public ResponseEntity<?>updateStudent(@PathVariable String id,@Valid @RequestBody Student student,Errors errors){
       if(errors.hasErrors()){
           String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(message);
       }
       boolean updateStudent=studentService.updateStudent(id,student);
       if(!updateStudent){
           return ResponseEntity.status(400).body(new ApiResponse("ID NOT FOUND"));
       }
       return ResponseEntity.status(200).body(new ApiResponse("student has Updated"));
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?>deleteStudent(@PathVariable String id){
       boolean deleteStudent=studentService.deleteStudent(id);
       if(!deleteStudent){
           return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
       }

       return ResponseEntity.status(200).body(new ApiResponse("student has been Deleted"));
   }

   @GetMapping("/getStudentByName/{id}/{name}")
   public ResponseEntity<?>getStudentName(@PathVariable String id,@PathVariable String name){
       Student getStudentName=studentService.getStudentName(id, name);
       if(getStudentName==null){
           return ResponseEntity.status(400).body(new ApiResponse("no Student id found "));
       }
       return ResponseEntity.status(200).body(getStudentName);
   }
   @GetMapping("/getByMajor/{major}")
   private ResponseEntity<?>getStudentMajor(@PathVariable String major){
       ArrayList<Student>getMajor=studentService.getMajor(major);
       if(getMajor.isEmpty()){
           return ResponseEntity.status(400).body(new ApiResponse("no Student found with this major"));
       }
       return ResponseEntity.status(200).body(getMajor);
   }























}
