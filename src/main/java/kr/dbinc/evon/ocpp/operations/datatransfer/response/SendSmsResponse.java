package kr.dbinc.evon.ocpp.operations.datatransfer.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendSmsResponse {
    private String status;
    private String reason;
}
