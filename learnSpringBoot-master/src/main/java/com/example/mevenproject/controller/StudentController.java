package com.example.mevenproject.controller;

import com.example.mevenproject.document.Student;
import com.example.mevenproject.exception.StudentNotFound;
import com.example.mevenproject.request.StudentRequest;
import com.example.mevenproject.response.StudentResponse;
import com.example.mevenproject.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/createStudent")
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        StudentResponse student1 = studentService.createStudent(studentRequest);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<?> getAllStudent() {
        List<Student> allStudent = studentService.getAllStudent();
        return new ResponseEntity<>(allStudent, HttpStatus.OK);
    }

    @GetMapping("/getStudentByRollno")
    public ResponseEntity<?> getStudentByRollno(@RequestParam int rollno,@RequestParam String section) throws StudentNotFound {
        ResponseEntity<?> entity;
        Student student = studentService.findStudenyByRollnoAndSection(rollno,section);
        if (!ObjectUtils.isEmpty(student)) {
            entity = new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            entity = new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
        }
        return entity;
    }

    @GetMapping("/getStudentBySection")
    public ResponseEntity<?> getStudentBySection( String section) throws StudentNotFound {
        ResponseEntity<?> entity;
        List<Student> student = studentService.findStudenyBysection(section);
        if (!ObjectUtils.isEmpty(student)) {
            entity = new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            entity = new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
        }
        return entity;
    }


    @PutMapping("/updateStudent/{rollno}")
    public ResponseEntity<?> updateStudent(@PathVariable int rollno, @RequestBody Student student) throws StudentNotFound {
        Student student1 = studentService.updateStudent(rollno, student);
        return new ResponseEntity<>(student1, HttpStatus.OK);
    }

    @RequestMapping("/deleteStudent/{rollno}/{section}")
    public ResponseEntity<?> deleteStudent(@PathVariable int rollno,@PathVariable String section) throws StudentNotFound {
        String student = studentService.deleteStudent(rollno,section);
        System.out.println("deleted");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/register")
    public String Register() {
        return "registration";
    }
//        //blog reading third party api

    @RequestMapping("/login")
    public String login(Model model) {
        return "studentLogin";
    }

    @RequestMapping("/loginPage")
    public ModelAndView studentWelcome(StudentRequest studentRequest) throws StudentNotFound {
        Student student = studentService.findStudentByEmailAndPassword(studentRequest.getEmail(), studentRequest.getPassword());
            ModelAndView modelAndView=new ModelAndView("studentWelcome");
            modelAndView.addObject("studentData",student);
            modelAndView.addObject("students",studentService.findStudenyBysection(student.getSection()));
            return modelAndView;
    }
}
