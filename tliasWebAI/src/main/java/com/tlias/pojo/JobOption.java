package com.tlias.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOption<T,D> {
    private List<T> jobList;
    private List<T> clazzList;
    private List<D> dataList;

    public JobOption(List<T> clazzList,List<D> dataList)
    {
        this.clazzList = clazzList;
        this.dataList = dataList;
    }
}

