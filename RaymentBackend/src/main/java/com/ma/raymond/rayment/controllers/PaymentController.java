package com.ma.raymond.rayment.controllers;

import com.ma.raymond.rayment.exceptions.AccountNotFoundException;
import com.ma.raymond.rayment.models.httpObject.ResponseDTO;
import com.ma.raymond.rayment.services.BalanceService;
import com.ma.raymond.rayment.services.CTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    BalanceService balanceService;
    @Autowired
    CTService ctService;

    @GetMapping("/balance")
    public ResponseDTO getBalance(@RequestParam("account_id") Integer accountId, @RequestParam("curr") String currency) throws AccountNotFoundException {
         Double balance= balanceService.getBalance(accountId, currency);
        return new ResponseDTO("", String.format("balance is %s %.2f",currency,balance), "", "temp instance", "helpUrl", balance);
    }


    @PutMapping("/CT")
    public ResponseDTO ct(@RequestParam("from_acc_id") Integer fromAccId, @RequestParam("to_acc_id") Integer toAccId, @RequestParam("curr") String curr, @RequestParam("amount") double amount) throws AccountNotFoundException {
        ctService.ct(fromAccId,toAccId,curr,amount);
        return new ResponseDTO("", String.format("Transfer %s %.2f OK ",curr,amount), "", "temp instance", "helpUrl", null);
    }
}
