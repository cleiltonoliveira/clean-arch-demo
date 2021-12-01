package com.example.usecases.student.adapter;

import com.example.domain.model.Student;

import java.util.List;

public interface StudentAdapter {

    Student save(Student student);

    boolean existsByEmail(String email);

    List<Student> listAll();
}
