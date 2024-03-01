package com.example.warzone.dtos.gunservice;

import java.util.List;

public class ApiGunResponse{
    private Object body;
    private List<String> errors;

    public ApiGunResponse(Object body, List<String> errors) {
        this.body = body;
        this.errors = errors;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
