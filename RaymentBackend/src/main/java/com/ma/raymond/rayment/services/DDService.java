package com.ma.raymond.rayment.services;

import com.ma.raymond.rayment.dao.CurrAccountDao;
import com.ma.raymond.rayment.exceptions.AccountNotFoundException;
import com.ma.raymond.rayment.models.CurrencyAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DDService {
    @Autowired
    CurrAccountDao currAccountDao;

    @Autowired
    DDAService ddaService;

    @Transactional
    public void dd(Integer fromAcctId, Integer toAccountId, String curr, double amount) throws AccountNotFoundException {
        if(!ddaService.isDDAuthorized(fromAcctId,toAccountId)){
            throw new RuntimeException("DDA not authorized");
        }
        CurrencyAccount fromAcc = currAccountDao.getAccount(fromAcctId, curr);
        CurrencyAccount toAcc = currAccountDao.getAccount(toAccountId, curr);

        fromAcc.setBalance(fromAcc.getBalance() - amount);
        toAcc.setBalance(toAcc.getBalance() + amount);
        currAccountDao.save(fromAcc);
        currAccountDao.save(toAcc);
    }
}
