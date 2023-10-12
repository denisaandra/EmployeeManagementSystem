package com.springboot.employeemanagementsystembackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    // Whenever a record not exist in the database, then rest api will throw this exception and will return a not found status to the client bc of the @ResponseStatus annotation
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
