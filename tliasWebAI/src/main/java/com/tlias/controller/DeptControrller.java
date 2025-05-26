package com.tlias.controller;

import com.tlias.pojo.Dept;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptControrller {

//    private static final Logger log = LoggerFactory.getLogger(DeptControrller.class);


    @Autowired
    private DeptService deptService;

//    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list(){
//        System.out.println("查询全部的部门数据");
        log.info("查询全部的部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping
    public Result delete(Integer id) {
//        System.out.println("id为"+id+"的员工已被删除");
        log.info("根据id删除部门：{}",id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Dept dept){
//        System.out.println("新增部门："+dept);
        log.info("新增部门：{}",dept);
        deptService.save(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id) {
//        System.out.println("获取到的id：" + id);
        log.info("获取到的id：{}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
//        System.out.println("修改部门：" + dept);
        log.info("修改部门：{}",dept);
        deptService.update(dept);
        return Result.success();
    }

}
