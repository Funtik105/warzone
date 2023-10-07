package com.example.warzone.controllers.exceptions;

public class LoadoutConflictException extends RuntimeException{
    public LoadoutConflictException(String message){
        super(message);
    }
}
