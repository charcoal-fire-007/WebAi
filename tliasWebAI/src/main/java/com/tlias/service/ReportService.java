package com.tlias.service;

import com.tlias.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * 统计员工数量
     */
    JobOption getEmpJobData();

    List<Map<String,Object>> getEmpGenderData();

}
