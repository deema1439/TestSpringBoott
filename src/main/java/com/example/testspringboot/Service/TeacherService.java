package com.example.testspringboot.Service;

import com.example.testspringboot.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher>teachers=new ArrayList<>();

    public ArrayList<Teacher>getTeachers(){
        return teachers;
    }



    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }


    public boolean UpdateTeacher(String id,Teacher teacher){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId().equals(id)){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }


    public boolean deleteTeacher(String id){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId().equals(id)){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public Teacher getTeacherId(String id){
        for(Teacher t:teachers){
            if(t.getId().equals(id)){
                return t;
            }
        }
        return null;
    }


   public ArrayList<Teacher>getSalary(Double salary){
        ArrayList<Teacher>result=new ArrayList<>();
        for(Teacher t:teachers){
            if(t.getSalary()>=salary){
                result.add(t);
            }
        }
        return result;

   }





















}
