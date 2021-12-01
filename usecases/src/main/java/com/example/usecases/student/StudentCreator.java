package com.example.usecases.student;

import com.example.usecases.student.adapter.StudentAdapter;
import com.example.domain.model.Student;
import com.example.usecases.exception.ResourceConflictException;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class StudentCreator {

    private StudentAdapter studentAdapter;

    @Inject
    public StudentCreator(StudentAdapter studentAdapter) {
        this.studentAdapter = studentAdapter;
    }

    public Student create(Student student){
        verifyIfEmailExists(student.getEmail());
        return  studentAdapter.save(student);
    }

    private void verifyIfEmailExists(String email) {
        if (studentAdapter.existsByEmail(email)) {
            throw new ResourceConflictException("An account already exists with this email");
        }
    }
}
