package com.indec325.msemail.services.exceptions;

public class MessageCouldnotBeSent extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MessageCouldnotBeSent(String msg){
        super(msg);
    }
}