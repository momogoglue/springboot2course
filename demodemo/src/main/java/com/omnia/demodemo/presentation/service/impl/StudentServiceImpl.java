package com.omnia.demodemo.presentation.service.impl;

import com.omnia.demodemo.data.dto.StudentDto;
import com.omnia.demodemo.data.entity.Student;
import com.omnia.demodemo.data.repository.StudentRepository;
import com.omnia.demodemo.presentation.service.intrf.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    public List<StudentDto> getAllStudents() {
        List<Student> studentEntities = this.studentRepository.findAll();
//        List<Student> studentEntities = this.studentRepository.findAll(PageRequest.of(0, 10)).getContent();
        List<StudentDto> studentDtos = new ArrayList<>();

        studentEntities.stream().map(Student::toStudentDto).forEach(studentDtos::add);

        return studentDtos;
    }
}
