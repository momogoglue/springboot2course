package com.omnia.demodemo.presentation.service.intrf;

import com.omnia.demodemo.data.dto.TeacherDto;
import com.omnia.demodemo.data.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();

    Page<Teacher> getAllTeachers(Pageable pageable);

    Teacher getTeacherById(Long teacherId);

    TeacherDto createTeacher(TeacherDto teacherDto);

    TeacherDto updateTeacher(TeacherDto teacherDto);
}
