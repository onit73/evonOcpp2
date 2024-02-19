package kr.dbinc.evon.ocpp.operations.datatransfer.response;

import kr.dbinc.evon.domain.charger.Charger;
import kr.dbinc.evon.session.PricePerTable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PricePerMemberResponse {

    public PricePerMemberResponse(PricePerTable pricePerTable,Charger charger){
        if(charger.getPriceType() == 1){
            highSet(pricePerTable);
        }else{
            lowSet(pricePerTable);
        }
    }


    private Float t00;

    private Float t01;

    private Float t02;

    private Float t03;

    private Float t04;

    private Float t05;

    private Float t06;

    private Float t07;

    private Float t08;

    private Float t09;

    private Float t10;

    private Float t11;

    private Float t12;

    private Float t13;

    private Float t14;

    private Float t15;

    private Float t16;

    private Float t17;

    private Float t18;

    private Float t19;

    private Float t20;

    private Float t21;

    private Float t22;

    private Float t23;

    private void lowSet(PricePerTable pricePerTable){
            this.t00 = lowPrice(pricePerTable,pricePerTable.getT00());
            this.t01 = lowPrice(pricePerTable,pricePerTable.getT01());
            this.t02 = lowPrice(pricePerTable,pricePerTable.getT02());
            this.t03 = lowPrice(pricePerTable,pricePerTable.getT03());
            this.t04 = lowPrice(pricePerTable,pricePerTable.getT04());
            this.t05 = lowPrice(pricePerTable,pricePerTable.getT05());
            this.t06 = lowPrice(pricePerTable,pricePerTable.getT06());
            this.t07 = lowPrice(pricePerTable,pricePerTable.getT07());
            this.t08 = lowPrice(pricePerTable,pricePerTable.getT08());
            this.t09 = lowPrice(pricePerTable,pricePerTable.getT09());
            this.t10 = lowPrice(pricePerTable,pricePerTable.getT10());
            this.t11 = lowPrice(pricePerTable,pricePerTable.getT11());
            this.t12 = lowPrice(pricePerTable,pricePerTable.getT12());
            this.t13 = lowPrice(pricePerTable,pricePerTable.getT13());
            this.t14 = lowPrice(pricePerTable,pricePerTable.getT14());
            this.t15 = lowPrice(pricePerTable,pricePerTable.getT15());
            this.t16 = lowPrice(pricePerTable,pricePerTable.getT16());
            this.t17 = lowPrice(pricePerTable,pricePerTable.getT17());
            this.t18 = lowPrice(pricePerTable,pricePerTable.getT18());
            this.t19 = lowPrice(pricePerTable,pricePerTable.getT19());
            this.t20 = lowPrice(pricePerTable,pricePerTable.getT20());
            this.t21 = lowPrice(pricePerTable,pricePerTable.getT21());
            this.t22 = lowPrice(pricePerTable,pricePerTable.getT22());
            this.t23 = lowPrice(pricePerTable,pricePerTable.getT23());
    }

    private Float lowPrice(PricePerTable pricePerTable,int grade){
        if(grade == -1){
            return pricePerTable.getLowLoadWithLow();
        }else if(grade ==0){
            return pricePerTable.getMidLoadWithLow();
        }else{
            return pricePerTable.getHighLoadWithLow();
        }
    }

    private void highSet(PricePerTable pricePerTable){
        this.t00 = highPrice(pricePerTable,pricePerTable.getT00());
        this.t01 = highPrice(pricePerTable,pricePerTable.getT01());
        this.t02 = highPrice(pricePerTable,pricePerTable.getT02());
        this.t03 = highPrice(pricePerTable,pricePerTable.getT03());
        this.t04 = highPrice(pricePerTable,pricePerTable.getT04());
        this.t05 = highPrice(pricePerTable,pricePerTable.getT05());
        this.t06 = highPrice(pricePerTable,pricePerTable.getT06());
        this.t07 = highPrice(pricePerTable,pricePerTable.getT07());
        this.t08 = highPrice(pricePerTable,pricePerTable.getT08());
        this.t09 = highPrice(pricePerTable,pricePerTable.getT09());
        this.t10 = highPrice(pricePerTable,pricePerTable.getT10());
        this.t11 = highPrice(pricePerTable,pricePerTable.getT11());
        this.t12 = highPrice(pricePerTable,pricePerTable.getT12());
        this.t13 = highPrice(pricePerTable,pricePerTable.getT13());
        this.t14 = highPrice(pricePerTable,pricePerTable.getT14());
        this.t15 = highPrice(pricePerTable,pricePerTable.getT15());
        this.t16 = highPrice(pricePerTable,pricePerTable.getT16());
        this.t17 = highPrice(pricePerTable,pricePerTable.getT17());
        this.t18 = highPrice(pricePerTable,pricePerTable.getT18());
        this.t19 = highPrice(pricePerTable,pricePerTable.getT19());
        this.t20 = highPrice(pricePerTable,pricePerTable.getT20());
        this.t21 = highPrice(pricePerTable,pricePerTable.getT21());
        this.t22 = highPrice(pricePerTable,pricePerTable.getT22());
        this.t23 = highPrice(pricePerTable,pricePerTable.getT23());
    }

    private Float highPrice(PricePerTable pricePerTable,int grade){
        if(grade == -1){
            return pricePerTable.getLowLoadWithLow2();
        }else if(grade ==0){
            return pricePerTable.getMidLoadWithLow2();
        }else{
            return pricePerTable.getHighLoadWithLow2();
        }
    }


    public static PricePerMemberResponse fixedMemberPrice(Float price){
        PricePerMemberResponse pricePerMemberResponse = new PricePerMemberResponse();
        pricePerMemberResponse.t00 = price;
        pricePerMemberResponse.t01 = price;
        pricePerMemberResponse.t02 = price;
        pricePerMemberResponse.t03 = price;
        pricePerMemberResponse.t04 = price;
        pricePerMemberResponse.t05 = price;
        pricePerMemberResponse.t06 = price;
        pricePerMemberResponse.t07 = price;
        pricePerMemberResponse.t08 = price;
        pricePerMemberResponse.t09 = price;
        pricePerMemberResponse.t10 = price;
        pricePerMemberResponse.t11 = price;
        pricePerMemberResponse.t12 = price;
        pricePerMemberResponse.t13 = price;
        pricePerMemberResponse.t14 = price;
        pricePerMemberResponse.t15 = price;
        pricePerMemberResponse.t16 = price;
        pricePerMemberResponse.t17 = price;
        pricePerMemberResponse.t18 = price;
        pricePerMemberResponse.t19 = price;
        pricePerMemberResponse.t20 = price;
        pricePerMemberResponse.t21 = price;
        pricePerMemberResponse.t22 = price;
        pricePerMemberResponse.t23 = price;

        return pricePerMemberResponse;
    }
}
