package com.ma.raymond.rayment.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String phone;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "account")
    @JsonIgnoreProperties("account")
    private List<CurrencyAccount> currencyAccountList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<CurrencyAccount> getCurrencyAccountList() {
        return currencyAccountList;
    }

    public void setCurrencyAccountList(List<CurrencyAccount> currencyAccountList) {
        this.currencyAccountList = currencyAccountList;
    }
}
