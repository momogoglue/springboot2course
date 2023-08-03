package com.omnia.demodemo.data.entity;

import com.omnia.demodemo.data.dto.TeacherDto;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long teacherId;

    @Column(name = "name", nullable = false)
    String teacherName;

    @Column(name = "email", nullable = false)
    String email;

    @OneToMany(mappedBy = "teacher")
    Set<Subject> subjectsTaught;

}
