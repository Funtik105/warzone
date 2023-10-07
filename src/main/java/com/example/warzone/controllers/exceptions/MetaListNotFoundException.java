package com.example.warzone.controllers.exceptions;

public class MetaListNotFoundException extends RuntimeException{
    public MetaListNotFoundException(Long id){
        super("Could not find metalist " + id);
    }
}
