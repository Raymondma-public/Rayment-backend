package com.ma.raymond.rayment.controllers;

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
    public double getBalance(@RequestParam("account_id") Integer accountId, @RequestParam("curr") String currency) {
        return balanceService.getBalance(accountId, currency);
    }


    @PutMapping("/CT")
    public String ct(@RequestParam("from_acc_id") Integer fromAccId, @RequestParam("to_acc_id") Integer toAccId, @RequestParam("curr") String curr, @RequestParam("amount") double amount) {
        ctService.ct(fromAccId,toAccId,curr,amount);
        return "OK";
    }
}
