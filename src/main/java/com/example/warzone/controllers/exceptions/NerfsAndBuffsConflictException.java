package com.example.warzone.controllers.exceptions;

import com.example.warzone.models.NerfsAndBuffs;

public class NerfsAndBuffsConflictException extends RuntimeException{
    public NerfsAndBuffsConflictException(String message){
        super(message);
    }
}
