package com.learning.springboot.utilities.exceptions;

import java.util.Date;

public class ErrorResponse {

    public ErrorResponse(String message) {
        super();
        this.message = message;
        this.timeStamp = new Date();
    }


    private String message;
    private Date timeStamp;
    private String errorDescription;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
