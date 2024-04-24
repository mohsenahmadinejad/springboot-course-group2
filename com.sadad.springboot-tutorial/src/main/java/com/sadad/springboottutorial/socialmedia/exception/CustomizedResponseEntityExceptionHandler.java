package com.sadad.springboottutorial.socialmedia.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> generalHandleException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> UserNotFoundHandleException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),
                 ex.getMessage(),
                request.getDescription(false));
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        StringBuilder errors=new StringBuilder();
        for (FieldError errorDetails: ex.getFieldErrors() ){
            errors.append(errors+errorDetails.getDefaultMessage());
            errors.append(" , ");
        }
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),
                errors.toString(),
                request.getDescription(false));

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);

    }

}
