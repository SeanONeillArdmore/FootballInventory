package com.footballinventory.exceptionhandler;

import com.footballinventory.exception.JerseyNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class InventoryExceptionHandler {
    @ExceptionHandler(value = Throwable.class)
    public void handleThrowable(Throwable t){
        log.error("Error", t);
    }

    @ExceptionHandler(value = JerseyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleThrowable(JerseyNotFoundException j){
        log.warn(j.getMessage());
    }
}

