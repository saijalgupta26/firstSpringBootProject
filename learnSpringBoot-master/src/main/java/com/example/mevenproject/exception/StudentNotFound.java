package com.example.mevenproject.exception;

import java.io.Serial;

public class StudentNotFound extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;
    public StudentNotFound(String error){
        super(error);
    }

}
