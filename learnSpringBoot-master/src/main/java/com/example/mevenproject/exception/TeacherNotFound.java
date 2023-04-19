package com.example.mevenproject.exception;

import java.io.Serial;

public class TeacherNotFound extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;
    public TeacherNotFound(String error){
        super(error);
    }
}
