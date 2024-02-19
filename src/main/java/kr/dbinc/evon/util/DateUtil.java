package kr.dbinc.evon.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public enum DateUtil {
    INSTANCE;

    public ZonedDateTime getNowUTCDate(){
        return ZonedDateTime.ofLocal(
                LocalDateTime.now(),
                ZoneOffset.UTC,
                ZoneOffset.ofHours(9)
        );
    }

    public ZonedDateTime getNowUTCDate(LocalDateTime time){
        return ZonedDateTime.ofLocal(
                time,
                ZoneOffset.UTC,
                ZoneOffset.ofHours(9)
        );
    }

    public String getNowUTCDate(int offset){
        return ZonedDateTime.ofLocal(
                LocalDateTime.now(),
                ZoneOffset.UTC,
                ZoneOffset.ofHours(offset)
        ).toString();
    }

    public String getUTCDate(LocalDateTime time, int offset){
        return ZonedDateTime.ofLocal(
                time,
                ZoneOffset.UTC,
                ZoneOffset.ofHours(offset)
        ).toString();
    }

    public LocalDateTime stringToDate(String time) {
        return LocalDateTime.parse(time, DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }
}
