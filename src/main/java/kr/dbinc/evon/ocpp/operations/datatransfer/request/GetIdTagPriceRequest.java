package kr.dbinc.evon.ocpp.operations.datatransfer.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetIdTagPriceRequest {

    private String idTag;
}
