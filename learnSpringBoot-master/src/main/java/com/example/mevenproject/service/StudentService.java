package com.example.mevenproject.service;

import com.example.mevenproject.document.Student;
import com.example.mevenproject.exception.StudentNotFound;
import com.example.mevenproject.request.StudentRequest;
import com.example.mevenproject.response.StudentResponse;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentResponse createStudent(StudentRequest studentRequest);

    List<Student> getAllStudent();

    Student findStudenyByRollnoAndSection(int rollno,String section);

    Student updateStudent(int rollno, Student student) throws StudentNotFound;

    String deleteStudent(int rollno,String section) throws StudentNotFound;

    Student findStudentByEmailAndPassword(String email,String password) throws StudentNotFound;
    List<Student> findStudenyBysection(String section);

}
