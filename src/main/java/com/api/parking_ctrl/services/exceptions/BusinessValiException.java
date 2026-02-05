package com.api.parking_ctrl.services.exceptions;

// criando uma Exception personalizada para regras de negócio
public class BusinessValiException extends RuntimeException{
    public BusinessValiException (String message){
        super (message);
    }
}
