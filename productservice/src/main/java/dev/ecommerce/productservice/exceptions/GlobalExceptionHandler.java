package dev.ecommerce.productservice.exceptions;

import dev.ecommerce.productservice.dtos.ExceptionsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionsDto> handleNotFoundExpection(NotFoundException notFoundException){
        return new ResponseEntity<>(new ExceptionsDto(HttpStatus.NOT_FOUND,notFoundException.getMessage()),
                HttpStatus.NOT_FOUND);
    }

}
