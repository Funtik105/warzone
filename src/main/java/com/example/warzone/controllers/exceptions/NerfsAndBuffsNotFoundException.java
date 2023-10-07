package com.example.warzone.controllers.exceptions;

public class NerfsAndBuffsNotFoundException extends RuntimeException{
    public NerfsAndBuffsNotFoundException(Long id){
        super("Could not find nerfsAndBuffs " + id);
    }
}
