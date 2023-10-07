package com.example.warzone.controllers.exceptions;

public class PerksNotFoundException extends RuntimeException{
    public PerksNotFoundException(Long id){super("Could not find perk "+id);}
}
