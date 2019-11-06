package com.ma.raymond.vinance;

import com.ma.raymond.vinance.models.FRA;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class FRATest {


    @Test
    public  void testSettlement(){
        LocalDate startDate=LocalDate.of(2019, Month.JUNE,1);
        LocalDate matureDate=LocalDate.of(2019, Month.AUGUST,31);

        double fixedRate=0.1288;
        double floatingRate=0.115;
        double principal=100;

        FRA fra=new FRA(fixedRate,principal,startDate,matureDate,365);
        System.out.println(fra.settlmentAmt(floatingRate));
    }
    @Test
    public  void testSettlement2(){
        LocalDate startDate=LocalDate.of(2019, Month.MARCH,1);
        LocalDate matureDate=LocalDate.of(2019, Month.MARCH,2);

        double fixedRate=0.12785;
        double floatingRate=0.115;
        double principal=100;

        FRA fra=new FRA(fixedRate,principal,startDate,matureDate,365);
        System.out.println(fra.settlmentAmt(floatingRate));
    }

    @Test
    public  void testSettlement3(){
        LocalDate startDate=LocalDate.of(2019, Month.MARCH,6);
        LocalDate matureDate=LocalDate.of(2019, Month.MARCH,1);

        double fixedRate=0.12785;
        double floatingRate=0.115;
        double principal=100;

        FRA fra=new FRA(fixedRate,principal,startDate,matureDate,365);
        System.out.println(fra.settlmentAmt(floatingRate));
    }
}
