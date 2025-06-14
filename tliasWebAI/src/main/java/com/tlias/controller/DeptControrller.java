package com.tlias.controller;

import com.tlias.anno.LogOperation;
import com.tlias.pojo.Dept;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptControrller {

    @Autowired
    private DeptService deptService;

    @LogOperation
    @GetMapping
    public Result list(){
        log.info("查询全部的部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @LogOperation
    @DeleteMapping
    public Result delete(@RequestParam("id") Integer id) {
        log.info("根据id删除部门：{}",id);
        if(null == deptService.deleteById(id)){
            log.info("删除成功：{}",id);
            return Result.success();
        }
        return Result.error("删除失败，部门下有员工信息");
    }

    @LogOperation
    @PostMapping
    public Result save(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.save(dept);
        return Result.success();
    }


    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id) {
        log.info("获取到的id：{}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @LogOperation
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门：{}",dept);
        deptService.update(dept);
        return Result.success();
    }

}
