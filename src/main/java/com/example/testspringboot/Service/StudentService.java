package com.example.testspringboot.Service;

import com.example.testspringboot.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student>students=new ArrayList<>();

    public ArrayList<Student>getStudents(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);

    }


    public boolean updateStudent(String id,Student student){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId().equals(id)){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(String id){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId().equals(id)){
                students.remove(i);
                return true;
            }
        }
        return false;
    }

   public Student getStudentName(String id,String name){
        for(Student s:students){
            if(s.getId().equals(id)) {
                if (s.getName().equalsIgnoreCase(name)) ;
                return s;
            }
        }
        return null;
   }


   public ArrayList<Student>getMajor(String major){
        ArrayList<Student>result=new ArrayList<>();
        for(Student s:students){
            if(s.getMajor().equalsIgnoreCase(major)){
                result.add(s);
            }
        }
        return result;
   }












}
