package com.springsecurity1.springsecurity1.data.exceptions;

public class StudentNotFoundException extends Exception{

    public StudentNotFoundException(String message){
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
