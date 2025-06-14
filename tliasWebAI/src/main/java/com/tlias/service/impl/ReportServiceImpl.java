package com.tlias.service.impl;

import com.tlias.mapper.EmpMapper;
import com.tlias.mapper.StudentMapper;
import com.tlias.pojo.JobOption;
import com.tlias.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption<String,Object> getEmpJobData(){
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        List<String> jobList = list.stream().map(dataMap ->(String)dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap ->dataMap.get("total")).toList();
        return new JobOption<String,Object>(jobList,null,dataList);
    }

    @Override
    public List<Map<String,Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public JobOption<String, Object> getStudentCountData() {
        List<Map<String,Object>> list = studentMapper.selectcountStudentData();
        List<String> clazzList = list.stream().map(dataMap ->(String)dataMap.get("clazz")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption<String,Object>(clazzList,dataList);
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return studentMapper.selectStudentDegreeData();
    }
}
