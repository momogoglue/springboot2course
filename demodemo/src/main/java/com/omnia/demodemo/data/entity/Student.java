package com.omnia.demodemo.data.entity;

import com.omnia.demodemo.data.dto.StudentDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long studentId;

    @Column(name = "name", nullable = false)
    String studentName;


    @ManyToMany(mappedBy = "studentsEnrolled")
    Set<Subject> subjectsEnrolled;


    public static StudentDto toStudentDto(Student student) {
        return StudentDto.builder()
                .studentId(student.getStudentId())
                .studentName(student.getStudentName())
//                .subjectsEnrolled(student.getSubjectsEnrolled())
                .build();
    }

}
