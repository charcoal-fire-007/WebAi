package com.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tlias.mapper.StudentMapper;
import com.tlias.pojo.PagesResult;
import com.tlias.pojo.Student;
import com.tlias.pojo.StudentQueryParam;
import com.tlias.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PagesResult<Student> list(StudentQueryParam studentQueryParam){
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());

        List<Student> list = studentMapper.selectList(studentQueryParam);
        Page<Student> page = (Page<Student>)list;

        return new PagesResult<>(page.getTotal(), page.getResult());
    }

    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());

        studentMapper.add(student);
    }

    @Override
    public void deleteById(List<Integer> ids) {
            studentMapper.delete(ids);
    }

    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getInfo(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());

        studentMapper.update(student);

    }

    @Override
    public void violation(Integer id, Integer score) {
        studentMapper.updateViolationScoreById(id, score);
    }

}
