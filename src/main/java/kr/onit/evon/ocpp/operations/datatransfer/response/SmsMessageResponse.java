package kr.onit.evon.ocpp.operations.datatransfer.response;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsMessageResponse {

    private String status;
}
