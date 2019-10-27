package com.ma.raymond.rayment.services;

import com.ma.raymond.rayment.dao.AccountDao;
import com.ma.raymond.rayment.models.Account;
import com.ma.raymond.rayment.models.CurrencyAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceService {
    @Autowired
    AccountDao accountDao;

    public Double getBalance(Integer accountId, String curr){
        Account acc=accountDao.getAccount(accountId);
        List<CurrencyAccount> currencyAccountList=acc.getCurrencyAccountList();
        for(CurrencyAccount currAcc:currencyAccountList){
            if(currAcc.getCurrency().equals(curr)){
               return  currAcc.getBalance();
            }
        }
        throw new RuntimeException("No such Currency Account");
    }
}
