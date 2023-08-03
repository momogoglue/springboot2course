package com.omnia.demodemo.data.dto;

import com.omnia.demodemo.data.entity.Subject;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherDto {

    Long teacherId;
    String teacherName;
    String email;
    Set<SubjectDto> subjectsTaught;
}
