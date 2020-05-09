package com.ma.raymond.rayment.controllers;

import com.ma.raymond.rayment.exceptions.AccountNotFoundException;
import com.ma.raymond.rayment.exceptions.InsufficientFundException;
import com.ma.raymond.rayment.models.httpObject.ResponseDTO;
import com.ma.raymond.rayment.services.BalanceService;
import com.ma.raymond.rayment.services.CTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    BalanceService balanceService;
    @Autowired
    CTService ctService;

    @Value("${bank}")
    private String currentBank;

    @GetMapping("/balance")
    public ResponseDTO getBalance(@RequestParam("account_id") Integer accountId, @RequestParam("curr") String currency) throws AccountNotFoundException {
        BigDecimal balance= balanceService.getBalance(accountId, currency);
        return new ResponseDTO("", String.format("balance is %s %.2f",currency,balance), "", "temp instance", "helpUrl", balance);
    }


    @PutMapping("/CT")
    public ResponseDTO ct(@RequestParam("from_acc_id") Integer fromAccId,@RequestParam(value="to_bank", required=false )String toBank, @RequestParam("to_acc_id") Integer toAccId, @RequestParam("curr") String curr, @RequestParam("amount") BigDecimal amount) throws AccountNotFoundException, InsufficientFundException {
        if(currentBank.equals(toBank) || currentBank==null){
            ctService.ct(fromAccId,toAccId,curr,amount);
        }else{
            //cross bank
            //query account

            //ct

        }

        return new ResponseDTO("", String.format("Transfer %s %.2f OK ",curr,amount), "", "temp instance", "helpUrl", null);
    }
}
