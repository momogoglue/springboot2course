package com.omnia.demodemo.data.dto;

import com.omnia.demodemo.data.entity.Subject;
import lombok.*;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

     Long studentId;
     String studentName;
     Set<SubjectDto> subjectsEnrolled;

    }
