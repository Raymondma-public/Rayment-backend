package com.ma.raymond.vinance;

import com.ma.raymond.vinance.models.FRA;

import java.time.LocalDate;
import java.time.Month;

public class FRATest {


    public  void main(String[] args){
        LocalDate startDate=LocalDate.of(2019, Month.MARCH,1);
        LocalDate matureDate=LocalDate.of(2019, Month.MAY,30);

        double fixedRate=0.12785;
        double floatingRate=0.115;
        double principal=100;

        FRA fra=new FRA(fixedRate,principal,startDate,matureDate,365);
        System.out.println(fra.settlmentAmt(floatingRate));
    }
}
