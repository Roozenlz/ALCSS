package com.roozen.alcss.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * @author <a href="https://roozen.top">Roozen</a>
 * @version 1.0
 * @since 2023/5/20
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception e){
      log.error(e.getMessage());
    }
}
