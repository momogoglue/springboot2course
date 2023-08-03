package com.omnia.demodemo.presentation.service.intrf;

import com.omnia.demodemo.data.dto.LessonDto;
import com.omnia.demodemo.data.entity.Lesson;
import com.omnia.demodemo.data.entity.Subject;

public interface LessonService {

    Lesson getLessonsOrderedByLessonName();

    Lesson createLesson(LessonDto lessonDto, Subject subject);
}
