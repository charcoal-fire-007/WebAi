package com.tlias.controller;


import com.tlias.pojo.PagesResult;
import com.tlias.pojo.Result;
import com.tlias.pojo.Student;
import com.tlias.pojo.StudentQueryParam;
import com.tlias.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/students")
@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result list(StudentQueryParam studentQueryParam){
        PagesResult<Student> pagesResult = studentService.list(studentQueryParam);
        log.info("pagesResult:{}",pagesResult);
        return Result.success(pagesResult);
    }

    @PostMapping
    public Result add(@RequestBody Student student) {
        studentService.save(student);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteById (@PathVariable String ids) {
        log.info("删除数据id:{}",ids);
        try {
            String[] idArray = ids.split(",");
            List<Integer> idList = new ArrayList<>();
            for (String id : idArray) {
                idList.add(Integer.parseInt(id.trim()));
            }
            studentService.deleteById(idList);
            return Result.success();
        } catch (NumberFormatException e) {
            log.error("删除失败，ID格式错误: {}", ids, e);
            return Result.error("ID格式错误");
        } catch (Exception e) {
            log.error("删除失败", e);
            return Result.error("删除失败");
        }
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("回显数据id:{}",id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("获取到的数据:{}",student);
         studentService.update(student);
         return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score) {
        log.info("获取到的学生id{},获取到的违纪分数{}",id,score);
        studentService.violation(id,score);
        return Result.success();
    }
}
