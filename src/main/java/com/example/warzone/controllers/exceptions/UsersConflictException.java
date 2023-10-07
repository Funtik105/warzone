package com.example.warzone.controllers.exceptions;

public class UsersConflictException extends RuntimeException{
    public UsersConflictException(String message){
        super(message);
    }
}
