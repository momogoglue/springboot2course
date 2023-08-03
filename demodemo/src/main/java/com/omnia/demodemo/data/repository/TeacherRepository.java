package com.omnia.demodemo.data.repository;

import com.omnia.demodemo.data.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

//    Teacher findByTeacherIdOrderBySubjectsTaught(Long id);
}
