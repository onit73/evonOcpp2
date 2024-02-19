package kr.dbinc.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetIdTagProfileRequest {

    private String idTag;
    private String parentIdTag;
}
