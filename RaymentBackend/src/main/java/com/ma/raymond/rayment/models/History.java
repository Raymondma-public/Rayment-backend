package com.ma.raymond.rayment.models;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    private Integer from;
//    private Integer to;
    private String currency;
    private BigDecimal amount;
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "from")
    private CurrencyAccount fromCurrencyAccount;

    @ManyToOne
    @JoinColumn(name = "to")
    private CurrencyAccount toCurrencyAccount;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public CurrencyAccount getFromCurrencyAccount() {
        return fromCurrencyAccount;
    }

    public void setFromCurrencyAccount(CurrencyAccount fromCurrencyAccount) {
        this.fromCurrencyAccount = fromCurrencyAccount;
    }

    public CurrencyAccount getToCurrencyAccount() {
        return toCurrencyAccount;
    }

    public void setToCurrencyAccount(CurrencyAccount toCurrencyAccount) {
        this.toCurrencyAccount = toCurrencyAccount;
    }
}
