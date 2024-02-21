package kr.onit.evon.ocpp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SendChargingRequest {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime end;
}
