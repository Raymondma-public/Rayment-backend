package com.ma.raymond.rayment.controllers;

import com.ma.raymond.rayment.models.Account;
import com.ma.raymond.rayment.services.AccountService;
import com.ma.raymond.rayment.services.DDAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/all")
    public List<Account> getAll() {
        List<Account> accountList=accountService.getAll();
        return accountList;
    }
}
