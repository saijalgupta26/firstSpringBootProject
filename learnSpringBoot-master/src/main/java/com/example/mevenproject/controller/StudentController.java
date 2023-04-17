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
    public ResponseEntity<?> getStudentByRollno(@RequestParam int rollno) throws StudentNotFound {
        ResponseEntity<?> entity;
        Student student = studentService.findStudenyByRollno(rollno);
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

    @DeleteMapping("/deleteStudent/{rollno}")
    public ResponseEntity<?> deleteStudent(@PathVariable int rollno) throws StudentNotFound {
        String student = studentService.deleteStudent(rollno);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/register")
    public String Register() {
        return "registration";
    }

    @RequestMapping(value = "/RegisterMe", method = RequestMethod.POST)
    public String registerMe(StudentRequest studentRequest) {
        studentService.createStudent(studentRequest);
        return "login";
    }

    @RequestMapping ("/login")
    public String login(Model model) {

        return "login";
    }

    @RequestMapping(value = "/loginPage")
    public String loginPage(StudentRequest studentRequest, Model model) throws StudentNotFound {
        Student student = studentService.findStudentByEmailAndPassword(studentRequest.getEmail(), studentRequest.getPassword());
        if(!ObjectUtils.isEmpty(student)) {
            model.addAttribute("students", studentService.getAllStudent());
            return "render";
        }
        else {
            return "login";
        }
    }







    /*public String newq(Model model)
    {
        model.addAttribute("students",studentService.getAllStudent());
        return "render";
    }*/
}
//find show  ->get
//create,inject the data->post
//t->any object
//    @RestControllerAdvice
//    public static class RestExceptionHandler extends ResponseEntityExceptionHandler {
//        @Override
//        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//            ErrorModel error = new ErrorModel(HttpStatus.BAD_REQUEST, "Validation Error", ex.getBindingResult().getAllErrors().iterator().next().getDefaultMessage());
//
//            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//        }
//    }
//graphana
//ngx deploy
