package com.example.mevenproject.repository;
import com.example.mevenproject.document.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student,String>
{
    Optional<Student> findByRollno(int rollno);
    Optional<Student> findByEmailAndPassword(String email,String password);
}
