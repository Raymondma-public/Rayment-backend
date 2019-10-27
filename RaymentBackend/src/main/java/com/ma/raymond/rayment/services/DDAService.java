package com.ma.raymond.rayment.services;

import com.ma.raymond.rayment.dao.AccountDao;
import com.ma.raymond.rayment.dao.DDADao;
import com.ma.raymond.rayment.models.Account;
import com.ma.raymond.rayment.models.DDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DDAService {
    @Autowired
    AccountDao accountDao;
    @Autowired
    DDADao ddaDao;

    public void authorize(Integer fromAccId, Integer toAccId) {
        Account fromAcc = accountDao.getAccount(fromAccId);
        Account toAcc = accountDao.getAccount(toAccId);

        DDA dda = new DDA();
        dda.setFromAcc(fromAcc);
        dda.setToAcc(toAcc);
        dda.setCreateDate(LocalDateTime.now());
        ddaDao.save(dda);
    }

    public boolean isDDAuthorized(Integer fromAccId, Integer toAccId) {
        Account fromAcc = accountDao.getAccount(fromAccId);
        Account toAcc = accountDao.getAccount(toAccId);
        DDA dda = ddaDao.getDDA(fromAcc, toAcc);
        if (dda != null) {
            return true;
        } else {
            return false;
        }
    }
}
