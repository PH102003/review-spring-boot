package com.api.parking_ctrl.controllers.handlers;

import com.api.parking_ctrl.exceptions.BusinessException;
import com.api.parking_ctrl.services.exceptions.BusinessValiException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Diz ao Spring: "Eu cuido dos erros de todos os Controllers"
public class GlobalExceptionHandler {

    // Este método será chamado toda vez que um 'BusinessException' for lançado
    @ExceptionHandler(BusinessValiException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessValiException ex) {
        
        // Vamos montar um "corpinho" de erro bonitinho para o Postman
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        body.put("status", HttpStatus.CONFLICT.value());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }
}