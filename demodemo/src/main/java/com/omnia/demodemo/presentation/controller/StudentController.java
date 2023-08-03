package com.omnia.demodemo.presentation.controller;

import com.omnia.demodemo.data.dto.StudentDto;
import com.omnia.demodemo.presentation.service.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentService;

    @GetMapping()
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> response = this.studentService.getAllStudents();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
