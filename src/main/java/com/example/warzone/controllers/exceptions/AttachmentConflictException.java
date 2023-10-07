package com.example.warzone.controllers.exceptions;

public class AttachmentConflictException extends RuntimeException{
    public AttachmentConflictException(String message){
        super(message);
    }
}
