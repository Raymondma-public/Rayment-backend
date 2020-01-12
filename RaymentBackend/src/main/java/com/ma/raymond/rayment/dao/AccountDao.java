package com.ma.raymond.rayment.dao;

import com.ma.raymond.rayment.models.Account;
import com.ma.raymond.rayment.models.CurrencyAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends CrudRepository<Account, Long> {


    @Query("SELECT acc FROM Account acc WHERE acc.id= :accountId ")
    Account getAccount(Integer accountId);

}
