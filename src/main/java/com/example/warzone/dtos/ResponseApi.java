package com.example.warzone.dtos;

import java.util.List;

public class ResponseApi {
    private Object body;
    private List<String> errors;

    public ResponseApi(Object body, List<String> errors) {
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
