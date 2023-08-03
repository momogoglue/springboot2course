package com.omnia.demodemo.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "subjects")
public class Subject implements Comparable<Subject> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long subjectId;

    @Column
    String subjectName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "teacherId", nullable = true)
    Teacher teacher;


    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "subject_student",
            joinColumns = { @JoinColumn(name = "subject_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") }
    )
    Set<Student> studentsEnrolled;

    @OneToMany(mappedBy = "subject")
    Set<Lesson> lessonsOfCourse;

    @Override
    public int compareTo(Subject o) {
        return o.subjectName.compareTo(this.subjectName);
    }
}
