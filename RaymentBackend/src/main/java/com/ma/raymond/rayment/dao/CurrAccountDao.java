package com.ma.raymond.rayment.dao;

import com.ma.raymond.rayment.models.Account;
import com.ma.raymond.rayment.models.CurrencyAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrAccountDao extends CrudRepository<CurrencyAccount, Long> {

    @Query("SELECT acc FROM CurrencyAccount acc WHERE acc.id= :accountId and acc.currency=:currency")
    CurrencyAccount getAccount(Integer accountId,String currency);
    
}
