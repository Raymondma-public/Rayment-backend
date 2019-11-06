package com.ma.raymond.rayment.services;

import com.ma.raymond.rayment.dao.AccountDao;
import com.ma.raymond.rayment.dao.CurrAccountDao;
import com.ma.raymond.rayment.models.Account;
import com.ma.raymond.rayment.models.CurrencyAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CTService {
    @Autowired
    AccountDao accountDao;
    @Autowired
    CurrAccountDao currAccountDao;


    @Transactional
    public void ct(Integer fromAcctId, Integer toAccountId, String curr, double amount) {
        List<CurrencyAccount> fromCurrList = accountDao.getAccount(fromAcctId).getCurrencyAccountList();
        List<CurrencyAccount> toCurrList = accountDao.getAccount(toAccountId).getCurrencyAccountList();
        CurrencyAccount fromAcc = null;
        CurrencyAccount toAcc = null;
        for (CurrencyAccount ac : fromCurrList) {
            if (ac.getCurrency().equals(curr)) {
                fromAcc = ac;
            }
        }

        for (CurrencyAccount ac : toCurrList) {
            if (ac.getCurrency().equals(curr)) {
                toAcc = ac;
            }
        }
        if (fromAcc == null || toAcc == null) {
            throw new RuntimeException("One Currency Account not found");
        }
        fromAcc.setBalance(fromAcc.getBalance() - amount);
        toAcc.setBalance(toAcc.getBalance() + amount);
        currAccountDao.save(fromAcc);
        currAccountDao.save(toAcc);
    }
}
