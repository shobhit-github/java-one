package com.learning.springboot.utilities.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;



@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {


    private Object parsingErrorIntoObject(FieldError errorObject) {

        Map<String, Object> errObj = new HashMap<>();

        errObj.put("fieldName", errorObject.getField());
        errObj.put("message", errorObject.getDefaultMessage());

        return errObj;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        List<Object> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::parsingErrorIntoObject)
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);
    }
}
