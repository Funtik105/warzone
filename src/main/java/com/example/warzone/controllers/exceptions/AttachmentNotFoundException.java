package com.example.warzone.controllers.exceptions;

public class AttachmentNotFoundException extends RuntimeException{
    public AttachmentNotFoundException(Long id){
        super("Could not find attachment " + id);
    }
}
