package com.example.demo.exception;

import java.time.LocalDateTime;

// Fix 1: Use correct SLF4J Logger import
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleAllExceptions(Exception ex) {
        // This will print full stack trace with line numbers in console
        logger.error("Exception occurred: ", ex);  // Remove {} placeholder, pass exception directly
        
        CustomErrorResponse error = new CustomErrorResponse(
            ex.getMessage(),
            LocalDateTime.now(),
            500
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
