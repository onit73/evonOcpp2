package kr.dbinc.evon.ocpp.operations.datatransfer.request;


import kr.dbinc.evon.ocpp.web.dto.BaseDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnnounceRequest extends BaseDto {

    private String vendorId;
    private String data;
    /*
    private String startTimeStamp;
    private String endTimeStamp;
    private String context;
     */
}
