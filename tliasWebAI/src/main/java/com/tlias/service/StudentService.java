package com.tlias.service;

import com.tlias.pojo.Clazz;
import com.tlias.pojo.PagesResult;
import com.tlias.pojo.Student;
import com.tlias.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PagesResult<Student> list(StudentQueryParam studentQueryParam);

    void save(Student student);

    void deleteById(List<Integer> ids);

    Student getInfo(Integer id);

    void update(Student student);

    void violation(Integer id, Integer score);
}
