package com.example.mevenproject.response;

import lombok.Data;

@Data
public class StudentResponse {
    private String name;
    private int rollno;
    private String section;
    private String email;
    private String password;
}
