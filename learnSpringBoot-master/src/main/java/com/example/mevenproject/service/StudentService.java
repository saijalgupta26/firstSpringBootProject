package com.example.mevenproject.service;

import com.example.mevenproject.document.Student;
import com.example.mevenproject.exception.StudentNotFound;
import com.example.mevenproject.request.StudentRequest;
import com.example.mevenproject.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse createStudent(StudentRequest studentRequest);

    List<Student> getAllStudent();

    Student findStudenyByRollno(int rollno);

    Student updateStudent(int rollno, Student student) throws StudentNotFound;

    String deleteStudent(int rollno) throws StudentNotFound;

    Student findStudentByEmailAndPassword(String email,String password) throws StudentNotFound;
}
