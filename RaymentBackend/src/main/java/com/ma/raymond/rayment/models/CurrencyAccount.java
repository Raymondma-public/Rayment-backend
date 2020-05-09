package com.ma.raymond.rayment.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class CurrencyAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String currency;
    private BigDecimal balance;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="account_id")
    @JsonIgnoreProperties("currencyAccountList")
    private Account account;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
