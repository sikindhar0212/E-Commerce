package dev.ecommerce.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionsDto {
    private HttpStatus httpStatus;
    private String message;
    public ExceptionsDto(HttpStatus httpStatus,String message){
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
