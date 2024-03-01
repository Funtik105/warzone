package com.example.warzone.dtos.response;

import java.util.List;

public class FindResponse<T> {
    private int totalCount;
    private List<T> body;
    private List<String> errors;

    public FindResponse() {
    }

    public FindResponse(int totalCount ,List<T> body, List<String> errors) {
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

    public int getSize() {
        return body != null ? body.size() : 0;
    }

    public List<T> getBody() {
        return body;
    }

    public void setBody(List<T> body) {
        this.body = body;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}