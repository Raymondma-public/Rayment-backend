package com.ma.raymond.rayment.services;

import com.ma.raymond.rayment.dao.AccountDao;
import com.ma.raymond.rayment.dao.DDADao;
import com.ma.raymond.rayment.exceptions.AccountNotFoundException;
import com.ma.raymond.rayment.models.Account;
import com.ma.raymond.rayment.models.DDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DDAService {
    @Autowired
    AccountDao accountDao;
    @Autowired
    DDADao ddaDao;

    public void authorize(Integer fromAccId, Integer toAccId) throws AccountNotFoundException {
        Optional<Account> fromAcc = accountDao.getAccountById(fromAccId);
        Optional<Account> toAcc = accountDao.getAccountById(toAccId);

        fromAcc.orElseThrow(()->new AccountNotFoundException(String.format("Account id %d not exist", fromAccId)));
        toAcc.orElseThrow(()->new AccountNotFoundException(String.format("Account id %d not exist", toAccId)));
        DDA dda = new DDA();
        dda.setFromAcc(fromAcc.get());
        dda.setToAcc(toAcc.get());
        dda.setCreateDate(LocalDateTime.now());
        ddaDao.save(dda);
    }

    public boolean isDDAuthorized(Integer fromAccId, Integer toAccId) throws AccountNotFoundException {
        Optional<Account> fromAcc = accountDao.getAccountById(fromAccId);
        Optional<Account> toAcc = accountDao.getAccountById(toAccId);

        fromAcc.orElseThrow(()->new AccountNotFoundException(String.format("Account id %d not exist", fromAccId)));
        toAcc.orElseThrow(()->new AccountNotFoundException(String.format("Account id %d not exist", toAccId)));

        DDA dda = ddaDao.getDDA(fromAcc.get(), toAcc.get());
        if (dda != null) {
            return true;
        } else {
            return false;
        }
    }
}
