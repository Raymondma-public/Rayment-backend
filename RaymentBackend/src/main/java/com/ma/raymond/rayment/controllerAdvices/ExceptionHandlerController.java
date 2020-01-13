package com.ma.raymond.rayment.controllerAdvices;

import com.ma.raymond.rayment.exceptions.AccountNotFoundException;
import com.ma.raymond.rayment.exceptions.InsufficientFundException;
import com.ma.raymond.rayment.models.httpObject.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = AccountNotFoundException.class)
    public ResponseDTO accountNotFound(AccountNotFoundException e) {
        return new ResponseDTO("",e.getMessage(),e.getMessage(),"temp instance","helpUrl",null);
    }

    @ExceptionHandler(value = InsufficientFundException.class)
    public ResponseDTO insufficientFund(AccountNotFoundException e) {
        return new ResponseDTO("",e.getMessage(),e.getMessage(),"temp instance","helpUrl",null);
    }
}
