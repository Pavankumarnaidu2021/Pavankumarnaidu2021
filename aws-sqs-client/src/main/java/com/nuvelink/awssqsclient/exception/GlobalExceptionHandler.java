package com.nuvelink.awssqsclient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(QueueNotFoundException.class)
    public ResponseEntity<?> handleQueueNotFoundException(QueueNotFoundException queueNotFoundException,
                                                          WebRequest webRequest) {
        ExceptionDetails errorDetails = new ExceptionDetails();
        errorDetails.setMessage(queueNotFoundException.getMessage());
        errorDetails.setStatus("404");
        errorDetails.setErrorCode(HttpStatus.NOT_FOUND.toString());
        errorDetails.setErrorSource(webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
