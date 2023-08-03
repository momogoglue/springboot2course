package com.omnia.demodemo.presentation.service.impl;

import com.omnia.demodemo.data.dto.LessonDto;
import com.omnia.demodemo.data.entity.Lesson;
import com.omnia.demodemo.data.entity.Subject;
import com.omnia.demodemo.data.repository.LessonRepository;
import com.omnia.demodemo.presentation.service.intrf.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    @Override
    public Lesson getLessonsOrderedByLessonName() {
        return null;
    }
//    @Override
//    public Lesson getLessonsOrderedByLessonName() {
//        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "course.lessonName");
//        Sort.Order order2 = new Sort.Order(Sort.Direction.DESC, "course.lessonName");
//        Sort.Order order3 = new Sort.Order(Sort.Direction.ASC, "course.lessonName");
//        Sort.Order order4 = new Sort.Order(Sort.Direction.ASC, "course.lessonName");
//        this.lessonRepository.findAll(Sort.by(order, order2, order3, order4));
//    }

    @Override
    public Lesson createLesson(LessonDto lessonDto, Subject subject) {
        Lesson lesson = Lesson.builder()
                .lessonName(lessonDto.getLessonName())
                .subject(subject)
                .build();

        return this.lessonRepository.save(lesson);
    }
}
