package com.example.usecases.student;

import com.example.domain.model.Student;
import com.example.usecases.student.adapter.StudentAdapter;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class StudentFinder {
    private final StudentAdapter studentAdapter;

    @Inject
    public StudentFinder(StudentAdapter studentAdapter) {
        this.studentAdapter = studentAdapter;
    }

    public List<Student> listAll(){
        return studentAdapter.listAll();
    }
}
