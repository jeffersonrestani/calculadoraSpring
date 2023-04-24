package br.com.jeff.calculadora.exceptions;

import com.sun.jdi.InvalidLineNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    //retém todos dos erros do tipo Exception da classe de excessões do Spring
    //vai mandar para os atributos da clase ExceptionResponse
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse>handleAllException(Exception e, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //retém somente os erros provenientes da classe InvalidLineNumberException
    @ExceptionHandler(InvalidLineNumberException.class)
    public final ResponseEntity<ExceptionResponse>handleInvalidNumberOperationException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
