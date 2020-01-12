package com.ma.raymond.rayment.controllers;

import com.ma.raymond.rayment.models.Account;
import com.ma.raymond.rayment.models.httpObject.ResponseDTO;
import com.ma.raymond.rayment.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @PutMapping("/createAccount")
    public ResponseDTO createAccount(Account account,@RequestParam("currs")  List<String> currs){
        System.out.printf("%s %s %s %s",account.getEmail(), account.getName(),account.getPhone(),account.getPassword());

        account.setId(null);
        account.setCreateDate(LocalDateTime.now());
        accountService.createUser(account,currs);

        return new ResponseDTO("","Account created","","temp instance","helpUrl",account);
    }

    @GetMapping("/all")
    public List<Account> getAll() {
        List<Account> accountList=accountService.getAll();
        return accountList;
    }
}
