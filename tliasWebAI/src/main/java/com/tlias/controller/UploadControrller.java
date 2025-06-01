package com.tlias.controller;

import com.tlias.pojo.Result;
import com.tlias.utils.AliyunOSSOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadControrller {

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping
    public Result upload(MultipartFile file) throws Exception{
        log.info("文件上传：{}",file.getOriginalFilename());
        if (null == file.getOriginalFilename()) {
            log.info("文件名称获取失败");
        }
        else {
             String name = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
             return Result.success(name);
        }
        return Result.error("文件名称获取失败");
    }
}
