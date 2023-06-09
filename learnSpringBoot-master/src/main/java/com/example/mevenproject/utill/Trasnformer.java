package com.example.mevenproject.utill;

import com.example.mevenproject.document.Student;
import com.example.mevenproject.request.StudentRequest;
import com.example.mevenproject.response.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class Trasnformer {
    public Student transformStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setPassword(studentRequest.getPassword());
        student.setSection(studentRequest.getSection());
        student.setRollno(studentRequest.getRollno());
        return student;
    }
    public StudentResponse prepareStudentResponse(Student student) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setName(student.getName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setPassword(student.getPassword());
        studentResponse.setSection(student.getSection());
        studentResponse.setRollno(student.getRollno());
        return studentResponse;
    }
}
