package com.ma.raymond.vinance.models;

import com.ma.raymond.vinance.utils.MathUtil;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class FRA {
    private double fixedRate;
    private double principal;
    private LocalDate startDate;
    private LocalDate matureDate;
    private long day;
    private long year;

    public FRA(double fixedRate, double principal, LocalDate startDate, LocalDate matureDate, int year) {
        this.fixedRate = fixedRate;
        this.principal = principal;
        this.startDate = startDate;
        this.matureDate = matureDate;
        this.day=DAYS.between(startDate,matureDate)+1;

        System.out.println("Day:"+day);
        this.year=year;

        if(this.day<=0){
            throw new RuntimeException("Date Range <= 0 ");
        }


    }

    public double settlmentAmt(double floatingRate){
        return MathUtil.round(((principal*(fixedRate-floatingRate)*day/year) / (1+floatingRate*(day/year))),4);
    }
}
