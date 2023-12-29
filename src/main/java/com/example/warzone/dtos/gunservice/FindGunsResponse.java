package com.example.warzone.dtos.gunservice;

import com.example.warzone.models.Gun;

import java.util.List;

public class FindGunsResponse{
    private int totalCount;
    private List<Gun> body;
    private List<String> errors;

    public FindGunsResponse() {
    }

    public FindGunsResponse(int totalCount, List<Gun> body, List<String> errors) {
        this.totalCount = totalCount;
        this.body = body;
        this.errors = errors;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Gun> getBody() {
        return body;
    }

    public void setBody(List<Gun> body) {
        this.body = body;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
