package com.ma.raymond.rayment.dao;

import com.ma.raymond.rayment.models.Account;
import com.ma.raymond.rayment.models.CurrencyAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountDao extends CrudRepository<Account, Long> {

    @Query("SELECT acc FROM Account acc WHERE acc.phone= :phone ")
    Optional<Account> getAccountByPhone(String phone);

    @Query("SELECT acc FROM Account acc WHERE acc.email= :email")
    Optional<Account> getAccountByEmail(String email);

    @Query("SELECT acc FROM Account acc WHERE acc.id= :accountId ")
    Optional<Account> getAccountById(Integer accountId);

}
