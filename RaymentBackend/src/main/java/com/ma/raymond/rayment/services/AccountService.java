package com.ma.raymond.rayment.services;

import com.ma.raymond.rayment.dao.AccountDao;
import com.ma.raymond.rayment.models.Account;
import com.ma.raymond.rayment.models.CurrencyAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountDao accountDao;

    public List<Account> getAll(){
        List<Account> accountList=new ArrayList<>();
        Iterable<Account> accountIterable=accountDao.findAll();
        for(Account a: accountIterable){
            accountList.add(a);
        }
        return accountList;
    }
}
