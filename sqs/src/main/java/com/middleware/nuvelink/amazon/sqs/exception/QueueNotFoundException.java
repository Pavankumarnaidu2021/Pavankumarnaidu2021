package com.middleware.nuvelink.amazon.sqs.exception;

public class QueueNotFoundException extends RuntimeException{

    public QueueNotFoundException(String message) {
        super(message);
    }
}
