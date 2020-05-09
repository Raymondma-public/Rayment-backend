package com.ma.raymond.rayment.services;

import com.ma.raymond.rayment.dao.AccountDao;
import com.ma.raymond.rayment.exceptions.AccountNotFoundException;
import com.ma.raymond.rayment.models.Account;
import com.ma.raymond.rayment.models.CurrencyAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountDao accountDao;


    public void createUser(Account account, List<String>currs){

        List<CurrencyAccount> currencyAccountList=new ArrayList();

        for(String curr:currs) {
            CurrencyAccount currencyAccount = new CurrencyAccount();
            currencyAccount.setBalance(BigDecimal.ZERO);
            currencyAccount.setCurrency(curr);
            currencyAccount.setAccount(account);
            account.addCurrencyAccount(currencyAccount);
        }
        accountDao.save(account);

    }
    public List<Account> getAll(){
        List<Account> accountList=new ArrayList<>();
        Iterable<Account> accountIterable=accountDao.findAll();
        for(Account a: accountIterable){
            accountList.add(a);
        }
        return accountList;
    }

    public Integer getAccountId(String type, String value) throws AccountNotFoundException {
        Optional<Account> account=Optional.empty();
        if(type.equals("email")){
            account=accountDao.getAccountByEmail(value);
        }else if(type.equals("phone")){
            account=accountDao.getAccountByPhone(value);
        }
        return account.orElseThrow(()->new AccountNotFoundException(String.format("%s %s not found",type,value))).getId();
    }
}
