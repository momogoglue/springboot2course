package com.omnia.demodemo.presentation.service.impl;

import com.omnia.demodemo.common.exception.TeacherNotFoundException;
import com.omnia.demodemo.data.dto.SubjectDto;
import com.omnia.demodemo.data.dto.TeacherDto;
import com.omnia.demodemo.data.entity.Teacher;
import com.omnia.demodemo.data.repository.TeacherRepository;
import com.omnia.demodemo.presentation.service.intrf.SubjectService;
import com.omnia.demodemo.presentation.service.intrf.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final SubjectService subjectService;

    @Override
    public List<Teacher> getAllTeachers() {
        return this.teacherRepository.findAll(PageRequest.of(0, 10)).getContent();
    }

    @Override
    public Page<Teacher> getAllTeachers(Pageable pageable) {
        return this.teacherRepository.findAll(pageable);
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        Optional<Teacher> result = this.teacherRepository.findById(teacherId);
        if (!result.isPresent()) {
            throw new TeacherNotFoundException("teacher not found");
        }
        return result.get();
    }

    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher = Teacher.builder()
                .teacherName(teacherDto.getTeacherName())
                .email(teacherDto.getEmail())
                .build();

        Teacher teacherEntity = this.teacherRepository.save(teacher);

        for (SubjectDto subjectDto : teacherDto.getSubjectsTaught()) {
            this.subjectService.createSubject(subjectDto, teacherEntity);
        }

//        teacherDto.getSubjectsTaught().stream().map((SubjectDto s)  -> this.subjectService.createSubject(s, teacherEntity));
        return null;
    }

    @Override
    public TeacherDto updateTeacher(TeacherDto teacherDto) {
        return null;
    }
}
