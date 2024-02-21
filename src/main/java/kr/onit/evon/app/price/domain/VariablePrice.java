package kr.onit.evon.app.price.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Entity
@Table(name = "db_com_price")
public class VariablePrice {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "sdate")
    private String startDate;

    @Column(name = "edate")
    private String endDate;

    @Column(name = "lowload1")
    private Float lowLoadWithLow; // 경 부하, 저압

    @Column(name = "lowload2")
    private Float lowLoadWithLow2;

    @Column(name = "midload1")
    private Float midLoadWithLow; // 중간 부하, 저압

    @Column(name = "midload2")
    private Float midLoadWithLow2;

    @Column(name = "hiload1")
    private Float highLoadWithLow; // 최대 부하, 저압

    @Column(name = "hiload2")
    private Float highLoadWithLow2;

    @Column(name = "t01")
    private Integer t01;

    @Column(name = "t02")
    private Integer t02;

    @Column(name = "t03")
    private Integer t03;

    @Column(name = "t04")
    private Integer t04;

    @Column(name = "t05")
    private Integer t05;

    @Column(name = "t06")
    private Integer t06;

    @Column(name = "t07")
    private Integer t07;

    @Column(name = "t08")
    private Integer t08;

    @Column(name = "t09")
    private Integer t09;

    @Column(name = "t10")
    private Integer t10;

    @Column(name = "t11")
    private Integer t11;

    @Column(name = "t12")
    private Integer t12;

    @Column(name = "t13")
    private Integer t13;

    @Column(name = "t14")
    private Integer t14;

    @Column(name = "t15")
    private Integer t15;

    @Column(name = "t16")
    private Integer t16;

    @Column(name = "t17")
    private Integer t17;

    @Column(name = "t18")
    private Integer t18;

    @Column(name = "t19")
    private Integer t19;

    @Column(name = "t20")
    private Integer t20;

    @Column(name = "t21")
    private Integer t21;

    @Column(name = "t22")
    private Integer t22;

    @Column(name = "t23")
    private Integer t23;

    @Column(name = "t24")
    private Integer t24;

    public boolean isInclude(LocalDate date){
        LocalDate startDate = convertStartDate(date.getYear());
        LocalDate endDate = convertEndDate(date.getYear());

        return date.isEqual(startDate) ||
                date.isEqual(endDate) ||
                (date.isAfter(startDate) && date.isBefore(endDate));

    }

    private LocalDate convertStartDate(int year){
        return convertDate(year, startDate);
    }
    private LocalDate convertEndDate(int year){
        return convertDate(year, endDate);
    }

    private LocalDate convertDate(int year, String monthAndDay){
        String[] tokens = monthAndDay.split("-");
        int month = Integer.parseInt(tokens[0]);
        int dayOfMonth = Integer.parseInt(tokens[1]);
        if(month == 2 && !IsoChronology.INSTANCE.isLeapYear(year)){
            dayOfMonth = dayOfMonth - 1;
        }

        return LocalDate.of(year, month, dayOfMonth);
    }

    public float getCurrentTimePrice(int currentHour){
        if(currentHour < 0 || currentHour > 23){
            throw new IllegalStateException("hour는 0~23값이어야 합니다. currentHour=" + currentHour);
        }
        int type = getType(currentHour);
        return getPrice(type);

    }

    private int getType(int currentHour) {
        int type = 0;

        switch (currentHour) {
            case 0:
                type = t24;
                break;
            case 1:
                type = t01;
                break;
            case 2:
                type = t02;
                break;
            case 3:
                type = t03;
                break;
            case 4:
                type = t04;
                break;
            case 5:
                type = t05;
                break;
            case 6:
                type = t06;
                break;
            case 7:
                type = t07;
                break;
            case 8:
                type = t08;
                break;
            case 9:
                type = t09;
                break;
            case 10:
                type = t10;
                break;
            case 11:
                type = t11;
                break;
            case 12:
                type = t12;
                break;
            case 13:
                type = t13;
                break;
            case 14:
                type = t14;
                break;
            case 15:
                type = t15;
                break;
            case 16:
                type = t16;
                break;
            case 17:
                type = t17;
                break;
            case 18:
                type = t18;
                break;
            case 19:
                type = t19;
                break;
            case 20:
                type = t20;
                break;
            case 21:
                type = t21;
                break;
            case 22:
                type = t22;
                break;
            case 23:
                type = t23;
                break;
        }
        return type;
    }

    private float getPrice(int type){

        switch (type){
            case -1:
                return lowLoadWithLow;
            case 0:
                return midLoadWithLow;
            case 1:
                return highLoadWithLow;
            default:
                throw new IllegalStateException("지원되지 않는 타입입니다. type =" + type);
        }
    }

}
