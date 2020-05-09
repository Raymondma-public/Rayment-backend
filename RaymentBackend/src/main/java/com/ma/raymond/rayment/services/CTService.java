package com.ma.raymond.rayment.services;

import com.ma.raymond.rayment.dao.AccountDao;
import com.ma.raymond.rayment.dao.CurrAccountDao;
import com.ma.raymond.rayment.exceptions.AccountNotFoundException;
import com.ma.raymond.rayment.exceptions.InsufficientFundException;
import com.ma.raymond.rayment.models.Account;
import com.ma.raymond.rayment.models.CurrencyAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CTService {
    @Autowired
    AccountDao accountDao;
    @Autowired
    CurrAccountDao currAccountDao;


    @Transactional
    public void ct(Integer fromAcctId, Integer toAccountId, String curr, BigDecimal amount) throws AccountNotFoundException, InsufficientFundException {
        Optional<Account> formAccount=accountDao.getAccountById(fromAcctId);
        Optional<Account> toAccount=accountDao.getAccountById(toAccountId);

        formAccount.orElseThrow(()->new AccountNotFoundException(String.format("Account id %d not exist", fromAcctId)));
        toAccount.orElseThrow(()->new AccountNotFoundException(String.format("Account id %d not exist", toAccountId)));


        List<CurrencyAccount> fromCurrList = formAccount.get().getCurrencyAccountList();
        List<CurrencyAccount> toCurrList = toAccount.get().getCurrencyAccountList();
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
        if(fromAcc.getBalance().subtract(amount).compareTo(BigDecimal.ZERO)<0){
            throw new InsufficientFundException(String.format("Insufficient Fund: %.2f",fromAcc.getBalance()));
        }

        fromAcc.setBalance(fromAcc.getBalance().subtract(amount) );
        toAcc.setBalance(toAcc.getBalance().add(amount));


        currAccountDao.save(fromAcc);
        currAccountDao.save(toAcc);
    }
}
