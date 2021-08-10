package com.learning.springboot.utilities.exceptions;

import org.springframework.validation.FieldError;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ValidationErrorResponse {

    public ValidationErrorResponse() {
        super();
        this.timeStamp = new Date();
        this.details = new HashMap<>();
    }

    private final Map<String, Object> details;
    private Date timeStamp;

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(FieldError errorObject) {
        this.details.put(errorObject.getField(), errorObject.getDefaultMessage());
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
