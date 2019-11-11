package com.ma.raymond.vinance.models;

import com.ma.raymond.vinance.utils.MathUtil;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class IRFuture {
    private double fixedRate;
    private double notional;
    private long day;
    private long year;

    public IRFuture(double impliedFFRate, double notional, LocalDate startDate, LocalDate matureDate, int year) {
        this.fixedRate = 100-impliedFFRate;
        this.notional = notional;
        this.day=DAYS.between(startDate,matureDate)+1;

        System.out.println("Day:"+day);
        this.year=year;

        if(this.day<=0){
            throw new RuntimeException("Date Range <= 0 ");
        }

    }

    public double settlmentAmt(double floatingRate){
        return MathUtil.round( notional * ( fixedRate - floatingRate) * day/year ,4);
    }
}
