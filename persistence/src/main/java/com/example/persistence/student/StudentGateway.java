package com.example.persistence.student;

import com.example.domain.model.Student;
import com.example.usecases.student.adapter.StudentAdapter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentGateway implements StudentAdapter {

    private final ModelMapper modelMapper;
    private final StudentRepository repository;

    public StudentGateway(ModelMapper modelMapper, StudentRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public Student save(Student student) {
        return toDomain(repository.save(toEntity(student)));
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public List<Student> listAll() {
        return repository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    private Student toDomain(StudentEntity entity) {
        return modelMapper.map(entity, Student.class);
    }

    private StudentEntity toEntity(Student domain) {
        return modelMapper.map(domain, StudentEntity.class);
    }
}
