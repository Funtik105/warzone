package com.example.warzone.controllers.exceptions;

public class LoadoutNotFoundException extends RuntimeException{
    public LoadoutNotFoundException(Long id){
        super("Could not find loadout " + id);
    }
}
