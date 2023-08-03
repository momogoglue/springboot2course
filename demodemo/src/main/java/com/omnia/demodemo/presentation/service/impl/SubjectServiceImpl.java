package com.omnia.demodemo.presentation.service.impl;

import com.omnia.demodemo.data.dto.LessonDto;
import com.omnia.demodemo.data.dto.SubjectDto;
import com.omnia.demodemo.data.entity.Subject;
import com.omnia.demodemo.data.entity.Teacher;
import com.omnia.demodemo.data.repository.SubjectRepository;
import com.omnia.demodemo.presentation.service.intrf.LessonService;
import com.omnia.demodemo.presentation.service.intrf.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    private final LessonService lessonService;

    @Override
    public Subject createSubject(SubjectDto subjectDto, Teacher teacher) {
        Subject subject = Subject.builder()
                .subjectName(subjectDto.getSubjectName())
                .teacher(teacher)
                .build();

        Subject subjectEntity = this.subjectRepository.save(subject);
        for(LessonDto lessonDto : subjectDto.getLessonsOfCourse()){
            this.lessonService.createLesson(lessonDto, subjectEntity);
        }

        return subjectEntity;
    }
}
