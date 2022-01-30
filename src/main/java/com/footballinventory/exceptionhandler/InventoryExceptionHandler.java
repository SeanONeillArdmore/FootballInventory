package com.footballinventory.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class InventoryExceptionHandler {
    @ExceptionHandler(value = Throwable.class)
    public void handleThrowable(Throwable t){
        log.error("Error", t);
    }
}

