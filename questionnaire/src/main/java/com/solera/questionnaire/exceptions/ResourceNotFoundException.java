package com.solera.questionnaire.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resource;
    private int id;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ResourceNotFoundException(String resource, int id) {
        super(String.format("%s not found with id %d", resource, id));
        this.resource = resource;
        this.id = id;
    }
}
