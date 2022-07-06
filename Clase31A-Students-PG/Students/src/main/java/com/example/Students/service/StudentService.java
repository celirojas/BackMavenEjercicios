package com.example.Students.service;

import com.example.Students.repository.IStudentRepository;

public class StudentService {
    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

}
