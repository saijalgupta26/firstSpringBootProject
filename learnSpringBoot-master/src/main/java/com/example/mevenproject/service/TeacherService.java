package com.example.mevenproject.service;
import com.example.mevenproject.document.Teacher;
import com.example.mevenproject.request.TeacherRequest;
import com.example.mevenproject.response.TeacherResponse;
import java.util.List;

public interface TeacherService {
    public TeacherResponse createTeacher(TeacherRequest teacherRequest);

    public List<Teacher> findAllTeacher();

    public String delete(String name);

    public Teacher updateTeacher(String name, Teacher teacher);

    public Teacher findTeacherByName(String name);
}
