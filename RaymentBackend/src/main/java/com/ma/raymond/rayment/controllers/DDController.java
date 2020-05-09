package com.ma.raymond.rayment.controllers;

import com.ma.raymond.rayment.exceptions.AccountNotFoundException;
import com.ma.raymond.rayment.exceptions.InsufficientFundException;
import com.ma.raymond.rayment.models.httpObject.ResponseDTO;
import com.ma.raymond.rayment.services.DDAService;
import com.ma.raymond.rayment.services.DDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("dd")
public class DDController {
    @Autowired
    DDService ddService;

    @Value("${bank}")
    private String currentBank;

    @PutMapping("/dd")
    public ResponseDTO ct(@RequestParam("from_acc_id") Integer fromAccId,@RequestParam(value="to_bank", required=false )String toBank, @RequestParam("to_acc_id") Integer toAccId, @RequestParam("curr") String curr, @RequestParam("amount") BigDecimal amount) throws AccountNotFoundException, InsufficientFundException {
        if(currentBank.equals(toBank) || currentBank==null){
        ddService.dd(fromAccId,toAccId,curr,amount);
        }else{
            //cross bank
            //query account

            //dd

        }
        return new ResponseDTO("", String.format("Direct Debit %s %.2f OK ",curr,amount), "", "temp instance", "helpUrl", null);
    }
}
