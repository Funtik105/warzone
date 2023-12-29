package com.example.warzone.dtos.gunservice;

import java.util.List;

public class FindGunsResponse{
    private int totalCount;
    private List<GunDto> body;
    private List<String> errors;

    public FindGunsResponse() {
    }

    public FindGunsResponse(int totalCount, List<GunDto> body, List<String> errors) {
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

    public List<GunDto> getBody() {
        return body;
    }

    public void setBody(List<GunDto> body) {
        this.body = body;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
