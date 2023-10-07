package com.example.warzone.controllers.exceptions;

public class GunNotFoundException extends RuntimeException{
    public GunNotFoundException (Long id){
        super("Could not find gun " + id);
    }
}
