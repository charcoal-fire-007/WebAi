package com.tlias.controller;


import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpQueryParam;
import com.tlias.pojo.PagesResult;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpControrller {

    @Autowired
    private EmpService empService;
    @GetMapping
    public Result list(EmpQueryParam empQueryParam) {
        PagesResult pagesResult = empService.List(empQueryParam);
        return Result.success(pagesResult);
    }

    @GetMapping("/list")
    public Result getAllList() {
        // 获取所有员工列表，不分页
        List<Object> list = empService.getAllList();
        return Result.success(list);
    }


    @PostMapping
    public Result save(@RequestBody Emp emp){
        empService.save(emp);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("获取到的id {}",ids);
        empService.delete(ids);
        return Result.success();
    }


    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        Emp emp  = empService.getInfo(id);
        return Result.success(emp);
    }


    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("获取到的员工所有信息：{}",emp);
        empService.update(emp);
        return Result.success();
    }
}
