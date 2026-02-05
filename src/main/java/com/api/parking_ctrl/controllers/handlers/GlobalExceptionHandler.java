package com.api.parking_ctrl.controllers.handlers;
import com.api.parking_ctrl.services.exceptions.BusinessValiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Cuida dos erros de todos os controllers
public class GlobalExceptionHandler {

    // Esse método é chamado toda vez que um 'BusinessException' for lançado
    @ExceptionHandler(BusinessValiException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessValiException ex) {
        
        // monta uma espécie de "corpo" de erro para o Postman ('chave' e 'valor' que será retornado)
        Map<String, Object> body = new HashMap<>();
        //quando o conflito aconteceu
        body.put("timestamp", LocalDateTime.now());
        //carrega a mensagem de erro (ex.:"Conflict: License Plate Car is already in use!")
        body.put("message", ex.getMessage());
        //Define o cabeçalho (Header) da resposta como 409
        body.put("status", HttpStatus.CONFLICT.value());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }
}