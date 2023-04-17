package com.example.mevenproject.controller;

import com.example.mevenproject.document.Teacher;
import com.example.mevenproject.request.TeacherRequest;
import com.example.mevenproject.response.TeacherResponse;
import com.example.mevenproject.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/teacher")
@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/createTeacher")
    public ResponseEntity<?> createTeacher(@Valid @RequestBody TeacherRequest teacherRequest) {
        TeacherResponse teacher1 = teacherService.createTeacher(teacherRequest);
        return new ResponseEntity<>(teacher1, HttpStatus.CREATED);
    }

    @GetMapping("/getTeacherByName/{name}")
    public ResponseEntity<?> getTeacherByName(@PathVariable String name) {
        ResponseEntity<?> entity;
        Teacher teacher = teacherService.findTeacherByName(name);
        if (!ObjectUtils.isEmpty(teacher)) {
            entity = new ResponseEntity<>(teacher, HttpStatus.OK);
        } else {
            entity = new ResponseEntity<>("Teacher Not Found", HttpStatus.NOT_FOUND);

        }
        return entity;

    }

    @DeleteMapping("/deleteTeacher/{name}")
    public ResponseEntity<?> deleteTeacher(@PathVariable String name) {
        String t = teacherService.delete(name);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @PutMapping("/updateTeacher/{name}")
    public ResponseEntity<?> updateTeacher(@PathVariable String name, Teacher teacher) {
        Teacher teacher1 = teacherService.updateTeacher(name, teacher);
        return new ResponseEntity<>(teacher1, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllTeacher() {
        List<Teacher> allTeacher = teacherService.findAllTeacher();
        return new ResponseEntity<>(allTeacher, HttpStatus.OK);
    }
}
//    public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher)
//    {
//        Teacher teacher1 = teacherService.createTeacher(teacher);
//        return new ResponseEntity<>(teacher1, HttpStatus.CREATED);
//    }
//fetch type eager and lazy
//many to many
