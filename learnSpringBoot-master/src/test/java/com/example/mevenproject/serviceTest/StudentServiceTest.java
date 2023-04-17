package com.example.mevenproject.serviceTest;

import com.example.mevenproject.document.Student;
import com.example.mevenproject.exception.StudentNotFound;
import com.example.mevenproject.repository.StudentRepository;
import com.example.mevenproject.service.StudentServiceImpl;
import com.example.mevenproject.utill.Trasnformer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;
    @Mock
    private Trasnformer trasnformer;

    @Test
    public void createStudentTest() {
        Mockito.when(trasnformer.transformStudent(Mockito.any())).thenReturn(MockObject.getStudent());
        Mockito.when(studentRepository.save(Mockito.any())).thenReturn(MockObject.getStudent());
        assertThatCode(() -> {
            studentService.createStudent(MockObject.getStudentRequest());
        }).doesNotThrowAnyException();
    }
    @Test
    public void createStudentTest_InvalidRequest() {

        assertThatCode(() -> {
            studentService.createStudent(null);
        }).doesNotThrowAnyException();
    }

    @Test
    public void deleteStudentTest() {
        //Mockito.when(studentRepository.findByRollno(Mockito.anyInt())).thenReturn(Optional.of(MockObject.getStudent()));
        assertThatCode(()->studentService.deleteStudent(Mockito.anyInt())).isInstanceOf(StudentNotFound.class);
    }
    @Test
    public void deleteStudentTest_Success() {
        Mockito.when(studentRepository.findByRollno(Mockito.anyInt())).thenReturn(Optional.of(MockObject.getStudent()));
        assertThatCode(() -> studentService.deleteStudent(Mockito.anyInt())).doesNotThrowAnyException();
    }
    @Test
    public void updateStudentTest_Success() {
        Mockito.when(studentRepository.findByRollno(Mockito.anyInt())).thenReturn(Optional.of(MockObject.getStudent()));
        assertThatCode(()->studentService.updateStudent(Mockito.anyInt(),MockObject.getStudent())).doesNotThrowAnyException();
    }
    @Test
    public void updateStudentTest_InvalidRequest() {
        //Mockito.when(studentRepository.findByRollno(Mockito.anyInt())).thenReturn(Optional.of(MockObject.getStudent()));
        assertThatCode(()->studentService.updateStudent(Mockito.anyInt(),MockObject.getStudent())).isInstanceOf(StudentNotFound.class);

    }

    @Test
    public void getAllStudentTest() {
        List<Student> student = List.of(MockObject.getStudent());
        Mockito.when(studentRepository.findAll()).thenReturn(student);
        assertThatCode(() -> studentService.getAllStudent()).doesNotThrowAnyException();
    }
    @Test
    public void getStudentByRollnoTest(){
        Mockito.when(studentRepository.findByRollno(Mockito.anyInt())).thenReturn(Optional.of(MockObject.getStudent()));
        assertThatCode(()->studentService.findStudenyByRollno(Mockito.anyInt())).doesNotThrowAnyException();

    }
}
//serila
//cloning
//clonable
//string buillder
////java 8
//
