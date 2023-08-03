package com.omnia.demodemo.data.repository;

import com.omnia.demodemo.data.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> { }
