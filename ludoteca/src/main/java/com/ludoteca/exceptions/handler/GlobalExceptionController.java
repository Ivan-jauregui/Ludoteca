package com.ludoteca.exceptions.handler;

import com.ludoteca.exceptions.response.InvalidStockException;
import com.ludoteca.exceptions.response.RecourseNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ErrorResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request){
        Map<String,String> errors=new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(e->errors.put(e.getField(),e.getDefaultMessage()));

        ErrorResponse response=buildExceptionReponse(
                HttpStatus.BAD_REQUEST,
                "Error en validacion de los datos enviados",
                request.getServletPath()
        );

        response.setValidations(errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }


    @ExceptionHandler(RecourseNotFoundException.class)
    private ResponseEntity<ErrorResponse> handlerMethodArgumentNotValidException(RecourseNotFoundException ex, HttpServletRequest request){

        ErrorResponse response=buildExceptionReponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                request.getServletPath()
        );


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }

    @ExceptionHandler(InvalidStockException.class)
    private ResponseEntity<ErrorResponse> handlerMethodArgumentNotValidException(InvalidStockException ex, HttpServletRequest request){

        ErrorResponse response=buildExceptionReponse(
                HttpStatus.CONFLICT,
                ex.getMessage(),
                request.getServletPath()
        );


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorResponse> handlerException(Exception ex, HttpServletRequest request){

        ErrorResponse response=buildExceptionReponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                request.getServletPath()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }

    private ErrorResponse buildExceptionReponse(HttpStatus status, String message, String path){
                return ErrorResponse.builder()
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(message)
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();
    }

}
