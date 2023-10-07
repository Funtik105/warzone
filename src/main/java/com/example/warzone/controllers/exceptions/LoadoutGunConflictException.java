package com.example.warzone.controllers.exceptions;

public class LoadoutGunConflictException extends RuntimeException{
    public LoadoutGunConflictException(String message){
        super(message);
    }
}
