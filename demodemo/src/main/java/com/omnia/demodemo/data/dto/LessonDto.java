package com.omnia.demodemo.data.dto;

import com.omnia.demodemo.data.entity.Subject;
import lombok.*;

import javax.persistence.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonDto {
    Long lessonId;
    Subject subject;
    String lessonName;
}
