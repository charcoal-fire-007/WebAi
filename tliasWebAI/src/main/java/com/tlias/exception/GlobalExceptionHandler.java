package com.tlias.exception;

import com.tlias.pojo.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理唯一键冲突异常（手机号重复）
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        String message = e.getMessage();
        if (message.contains("emp.phone")) {
            return Result.error("手机号已存在，请使用其他手机号");
        }
        // 其他唯一键冲突的通用处理
        return Result.error("数据已存在，请勿重复添加");
    }

}
