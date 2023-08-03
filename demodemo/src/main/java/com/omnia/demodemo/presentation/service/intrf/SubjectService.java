package com.omnia.demodemo.presentation.service.intrf;

import com.omnia.demodemo.data.dto.SubjectDto;
import com.omnia.demodemo.data.entity.Subject;
import com.omnia.demodemo.data.entity.Teacher;

public interface SubjectService {

    Subject createSubject(SubjectDto subjectDto, Teacher teacher);
}
