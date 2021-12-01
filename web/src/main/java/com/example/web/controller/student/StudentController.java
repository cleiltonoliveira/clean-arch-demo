package com.example.web.controller.student;

import com.example.domain.model.Student;
import com.example.usecases.student.StudentCreator;
import com.example.usecases.student.StudentFinder;
import com.example.web.controller.student.dto.StudentCreationRequest;
import com.example.web.controller.student.dto.StudentResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class StudentController {
    private StudentCreator studentCreator;
    private StudentFinder studentFinder;
    private ModelMapper modelMapper;

    @PostMapping("public/students")
    public ResponseEntity<?> createStudent(@RequestBody @Valid StudentCreationRequest studentCreationRequest) {
        var student = toStudent(studentCreationRequest);
        return new ResponseEntity<>(toStudentResponse(studentCreator.create(student)), HttpStatus.CREATED);
    }

    @GetMapping("public/students")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(studentFinder.listAll().stream().map(this::toStudentResponse), HttpStatus.OK);
    }

    private StudentResponse toStudentResponse(Student student) {
        return modelMapper.map(student, StudentResponse.class);
    }

    private Student toStudent(StudentCreationRequest request) {
        return modelMapper.map(request, Student.class);
    }

}
