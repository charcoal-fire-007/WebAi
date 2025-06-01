package com.tlias.service.impl;

import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.JobOption;
import com.tlias.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData(){
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap ->dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap ->dataMap.get("total")).toList();
        return new JobOption(jobList,dataList);
    }

    @Override
    public List<Map<String,Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
}
