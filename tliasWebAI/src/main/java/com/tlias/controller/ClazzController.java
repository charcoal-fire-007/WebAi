package com.tlias.controller;


import com.tlias.anno.LogOperation;
import com.tlias.pojo.Clazz;
import com.tlias.pojo.ClazzQueryParam;
import com.tlias.pojo.PagesResult;
import com.tlias.pojo.Result;
import com.tlias.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
//    分页查询班级列表数据

    @LogOperation
    @GetMapping
    public Result list(ClazzQueryParam clazzQueryParam) {
        log.info("接受到的班级信息{}",clazzQueryParam);
        PagesResult list = clazzService.List(clazzQueryParam);
        log.info("查询班级信息{}",list);
        return Result.success(list);
    }

    @LogOperation
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("接受到前端的数据{}",clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    @LogOperation
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        log.info("接受到的前端传入的id{}",id);
        clazzService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }

    @LogOperation
    @PutMapping
    public Result update(@RequestBody Clazz clazz)
    {
        clazzService.update(clazz);
        return Result.success();
    }

    @GetMapping("/list")
    public Result getAllList() {
        List<Clazz> list = clazzService.getAllList();
        return Result.success(list);
    }
}



