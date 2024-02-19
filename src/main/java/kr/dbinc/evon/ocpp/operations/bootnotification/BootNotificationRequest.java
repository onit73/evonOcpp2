package kr.dbinc.evon.ocpp.operations.bootnotification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.dbinc.evon.ocpp.types.RequestType;
import lombok.Getter;

@Getter
public class BootNotificationRequest implements RequestType {

    private final String chargeBoxSerialNumber;
    private final String chargePointModel;
    private final String chargePointSerialNumber;
    private final String chargePointVendor;
    private final String firmwareVersion;
    private final String iccid;
    private final String imsi;
    private final String meterSerialNumber;
    private final String meterType;

    @JsonCreator
    public BootNotificationRequest(
            @JsonProperty(value = "chargePointModel", required = true) String chargePointModel,
            @JsonProperty(value = "chargePointVendor", required = true) String chargePointVendor,

            @JsonProperty(value = "chargeBoxSerialNumber") String chargeBoxSerialNumber,
            @JsonProperty(value = "chargePointSerialNumber") String chargePointSerialNumber,
            @JsonProperty(value = "firmwareVersion") String firmwareVersion,
            @JsonProperty(value = "iccid") String iccid,
            @JsonProperty(value = "imsi") String imsi,
            @JsonProperty(value = "meterSerialNumber") String meterSerialNumber,
            @JsonProperty(value = "meterType") String meterType
    ){
        this.chargeBoxSerialNumber = chargeBoxSerialNumber;
        this.chargePointModel = chargePointModel;
        this.chargePointSerialNumber = chargePointSerialNumber;
        this.chargePointVendor = chargePointVendor;
        this.firmwareVersion = firmwareVersion;
        this.iccid = iccid;
        this.imsi = imsi;
        this.meterSerialNumber = meterSerialNumber;
        this.meterType = meterType;
    }
}
