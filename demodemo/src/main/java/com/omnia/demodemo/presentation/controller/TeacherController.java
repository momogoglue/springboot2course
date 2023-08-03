package com.omnia.demodemo.presentation.controller;

import com.omnia.demodemo.data.dto.TeacherDto;
import com.omnia.demodemo.data.entity.Teacher;
import com.omnia.demodemo.presentation.service.intrf.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> createTeacher(@RequestBody TeacherDto teacherDto) {

        teacherService.createTeacher(teacherDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<Page<Teacher>> getAllTeachers(
            @RequestParam(required = false, value = "page", defaultValue = "0") int page,
            @RequestParam(required = false, value = "size",  defaultValue = "1") int size) {

        Page<Teacher> responseBody = this.teacherService.getAllTeachers(PageRequest.of( (int) page,  (int) size));
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping(value = "/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("teacherId") Long teacherId) {
        Teacher responseBody = this.teacherService.getTeacherById(teacherId);
        if(Objects.isNull(responseBody)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
