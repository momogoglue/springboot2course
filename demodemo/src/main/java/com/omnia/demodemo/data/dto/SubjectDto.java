package com.omnia.demodemo.data.dto;

import com.omnia.demodemo.data.entity.Teacher;
import lombok.*;

import java.util.Set;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubjectDto {

    Long subjectId;

    String subjectName;

    Teacher teacher;

    Set<StudentDto> studentsEnrolled;

    Set<LessonDto> lessonsOfCourse;
}
