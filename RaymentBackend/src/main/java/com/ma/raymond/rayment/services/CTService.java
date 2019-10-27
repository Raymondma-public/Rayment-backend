package com.ma.raymond.rayment.services;

import com.ma.raymond.rayment.dao.AccountDao;
import com.ma.raymond.rayment.dao.CurrAccountDao;
import com.ma.raymond.rayment.models.Account;
import com.ma.raymond.rayment.models.CurrencyAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CTService {
    @Autowired
    CurrAccountDao currAccountDao;


    @Transactional
    public void ct(Integer fromAcctId, Integer toAccountId, String curr, double amount){
        CurrencyAccount fromAcc=currAccountDao.getAccount(fromAcctId,curr);
        CurrencyAccount toAcc=currAccountDao.getAccount(toAccountId,curr);

        fromAcc.setBalance(fromAcc.getBalance()-amount);
        toAcc.setBalance(toAcc.getBalance()+amount);
        currAccountDao.save(fromAcc);
        currAccountDao.save(toAcc);
    }
}
