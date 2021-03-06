package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.StudentModel;

public class InMemoryStudentService implements StudentService {
    private static List<StudentModel> studentList = new ArrayList<StudentModel>();

    @Override
    public StudentModel selectStudent(String npm) {
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getNpm().equalsIgnoreCase(npm)) {
                return studentList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<StudentModel> selectAllStudents() {
        return studentList;
    }

    @Override
    public void addStudent(StudentModel student) {
        studentList.add(student);
    }

    @Override
    public boolean delete(String npm) {
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getNpm().equalsIgnoreCase(npm)) {
                studentList.remove(i);
                return true;
            }
        }
        return false;
    }
}