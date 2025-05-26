package com.tlias.controller;


import com.tlias.pojo.PagesResult;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpControrller {

    @Autowired
    private EmpService empService;
    @GetMapping
    public Result list(Integer page,Integer pageSize) {
        PagesResult pagesResult = empService.List(page,pageSize);
        return Result.success(pagesResult);
    }
}
