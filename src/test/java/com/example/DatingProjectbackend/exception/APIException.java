package com.example.DatingProjectbackend.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public class APIException extends RuntimeException{
    private HttpStatus status;
    private String message;

}
