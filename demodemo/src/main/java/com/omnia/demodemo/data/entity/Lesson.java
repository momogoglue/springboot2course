package com.omnia.demodemo.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity(name = "lessons")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lesson{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long lessonId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subjectId", nullable = true)
    Subject subject;

    @Column(name = "lessonName", nullable = false)
    String lessonName;
}
