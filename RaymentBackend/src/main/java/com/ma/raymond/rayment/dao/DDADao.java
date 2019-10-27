package com.ma.raymond.rayment.dao;

import com.ma.raymond.rayment.models.Account;
import com.ma.raymond.rayment.models.DDA;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DDADao extends CrudRepository<DDA, Long> {

    @Query("SELECT dda FROM DDA dda WHERE dda.fromAcc=:fromAcc and dda.toAcc=:toAcc ")
    DDA getDDA(Account fromAcc, Account toAcc);

}
