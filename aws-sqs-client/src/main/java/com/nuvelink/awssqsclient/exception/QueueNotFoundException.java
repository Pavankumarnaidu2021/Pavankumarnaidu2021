package com.nuvelink.awssqsclient.exception;

public class QueueNotFoundException extends RuntimeException{

    public QueueNotFoundException(String message) {
        super(message);
    }
}
