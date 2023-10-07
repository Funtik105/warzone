package com.example.warzone.controllers.exceptions;

public class LoadoutGunNotFoundException extends RuntimeException{
    public LoadoutGunNotFoundException(Long id){
        super("Could not find loadoutGun" + id);
    }
}
