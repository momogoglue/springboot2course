package com.omnia.demodemo.data.repository;

import com.omnia.demodemo.data.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
