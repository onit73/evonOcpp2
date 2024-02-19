package kr.dbinc.evon.session;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import kr.dbinc.evon.app.price.domain.VariablePrice;
import kr.dbinc.evon.domain.charger.Charger;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@Getter
@ToString
public class PricePerTable {

    private Float lowLoadWithLow; // 경 부하, 저압

    private Float lowLoadWithLow2;

    private Float midLoadWithLow; // 중간 부하, 저압

    private Float midLoadWithLow2;

    private Float highLoadWithLow; // 최대 부하, 저압

    private Float highLoadWithLow2;

    private Integer t00;

    private Integer t01;

    private Integer t02;

    private Integer t03;

    private Integer t04;

    private Integer t05;

    private Integer t06;

    private Integer t07;

    private Integer t08;

    private Integer t09;

    private Integer t10;

    private Integer t11;

    private Integer t12;

    private Integer t13;

    private Integer t14;

    private Integer t15;

    private Integer t16;

    private Integer t17;

    private Integer t18;

    private Integer t19;

    private Integer t20;

    private Integer t21;

    private Integer t22;

    private Integer t23;



    public void changePricePerHour(List<VariablePrice> variablePriceList){
        //내용 변경 구현.
        LocalDateTime now = LocalDateTime.now();

        VariablePrice todayPriceTable = variablePriceList.stream()
                .filter(p -> p.isInclude(now.toLocalDate()))
                .collect(Collectors.toList()).get(0);

        VariablePrice tomorrowPriceTable = variablePriceList.stream()
                .filter(p -> p.isInclude(now.plusDays(1L).toLocalDate()))
                .collect(Collectors.toList()).get(0);

        int nowHour = now.getHour();
        //날짜가 바뀌면 다음날 테이블 정보로 일부 갱신. (경,중,고부하값값)
       if(nowHour == 0)  changeLoadWith(tomorrowPriceTable);
        else changeLoadWith(todayPriceTable);

        for(int i=nowHour ; i<24 ; i++){
            setPrice(todayPriceTable,i);
        }
        for(int i=0; i<nowHour; i++){
            setPrice(tomorrowPriceTable,i);
        }
    }


    private void changeLoadWith (VariablePrice variablePrice){
            this.lowLoadWithLow = variablePrice.getLowLoadWithLow();
            this.lowLoadWithLow2 = variablePrice.getLowLoadWithLow2();
            this.midLoadWithLow = variablePrice.getMidLoadWithLow();
            this.midLoadWithLow2 = variablePrice.getMidLoadWithLow2();
            this.highLoadWithLow = variablePrice.getHighLoadWithLow();
            this.highLoadWithLow2 = variablePrice.getHighLoadWithLow2();
    }

    private void setPrice(VariablePrice variablePrice , int hour){
        switch (hour){
            case 0:
                this.t00 = variablePrice.getT24();
                break;
            case 1:
                this.t01 = variablePrice.getT01();
                break;

            case 2:
                this.t02 = variablePrice.getT02();
                break;
            case 3:
                this.t03 = variablePrice.getT03();
                break;

            case 4:
                this.t04 = variablePrice.getT04();
                break;
            case 5:
                this.t05 = variablePrice.getT05();
                break;
            case 6:
                this.t06 = variablePrice.getT06();
                break;
            case 7:
                this.t07 = variablePrice.getT07();
                break;
            case 8:
                this.t08 = variablePrice.getT08();
                break;
            case 9:
                this.t09 = variablePrice.getT09();
                break;
            case 10:
                this.t10 = variablePrice.getT10();
                break;
            case 11:
                this.t11 = variablePrice.getT11();
                break;
            case 12:
                this.t12 = variablePrice.getT12();
                break;
            case 13:
                this.t13 = variablePrice.getT13();
                break;
            case 14:
                this.t14 = variablePrice.getT14();
                break;
            case 15:
                this.t15 = variablePrice.getT15();
                break;
            case 16:
                this.t16 = variablePrice.getT16();
                break;
            case 17:
                this.t17 = variablePrice.getT17();
                break;
            case 18:
                this.t18 = variablePrice.getT18();
                break;
            case 19:
                this.t19 = variablePrice.getT19();
                break;
            case 20:
                this.t20 = variablePrice.getT20();
                break;
            case 21:
                this.t21 = variablePrice.getT21();
                break;
            case 22:
                this.t22 = variablePrice.getT22();
                break;
            case 23:
                this.t23 = variablePrice.getT23();
                break;
        }
    }
}
