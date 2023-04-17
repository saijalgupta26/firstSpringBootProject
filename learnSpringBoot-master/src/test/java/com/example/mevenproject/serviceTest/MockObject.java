package com.example.mevenproject.serviceTest;

import com.example.mevenproject.document.Student;
import com.example.mevenproject.request.StudentRequest;
import lombok.Data;

@Data
public class MockObject {
    public static StudentRequest getStudentRequest(){
        StudentRequest studentRequest=new StudentRequest();
        studentRequest.setName("text");
        studentRequest.setRollno(12);
        studentRequest.setEmail("s@S12");
        studentRequest.setSection("AS");
        studentRequest.setPassword("er@eE$23rere");
        return studentRequest;
    }
    public static Student getStudent() {
        Student student=new Student();
        student.setName("text");
        student.setRollno(12);
        student.setEmail("s@S12");
        student.setSection("AS");
        student.setPassword("er@eE$23rere");
        return student;
    }
    //create mock method for studentRequest
    //object studenntRequest

}
