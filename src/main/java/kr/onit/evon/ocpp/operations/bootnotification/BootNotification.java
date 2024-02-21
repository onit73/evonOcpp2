package kr.onit.evon.ocpp.operations.bootnotification;


import kr.onit.evon.ocpp.types.CiString;


public class BootNotification {
    private final CiString chargeBoxSerialNumber;
    private final CiString chargePointModel;
    private final CiString chargePointSerialNumber;
    private final CiString chargePointVendor;
    private final CiString firmwareVersion;
    private final CiString iccid;
    private final CiString imsi;
    private final CiString meterSerialNumber;
    private final CiString meterType;

    private BootNotification(BootNotificationRequest request){
        this.chargeBoxSerialNumber = new CiString(request.getChargeBoxSerialNumber(), CiString.Length.TYPE25);
        this.chargePointModel = new CiString(request.getChargePointModel(), CiString.Length.TYPE20);
        this.chargePointSerialNumber = new CiString(request.getChargePointSerialNumber(), CiString.Length.TYPE25);
        this.chargePointVendor = new CiString(request.getChargePointVendor(), CiString.Length.TYPE25);
        this.firmwareVersion = new CiString(request.getFirmwareVersion(), CiString.Length.TYPE50);
        this.imsi = new CiString(request.getImsi(), CiString.Length.TYPE50);
        this.iccid = new CiString(request.getIccid(), CiString.Length.TYPE20);
        this.meterSerialNumber = new CiString(request.getMeterSerialNumber(), CiString.Length.TYPE25);
        this.meterType = new CiString(request.getMeterType(), CiString.Length.TYPE20);
    }

    public static BootNotification fromRequest(BootNotificationRequest request){
        return new BootNotification(request);
    }

    public String getChargeBoxSerialNumber() {
        return chargeBoxSerialNumber.getValue();
    }

    public String getChargePointModel() {
        return chargePointModel.getValue();
    }

    public String getChargePointSerialNumber() {
        return chargePointSerialNumber.getValue();
    }

    public String getChargePointVendor() {
        return chargePointVendor.getValue();
    }

    public String getFirmwareVersion() {
        return firmwareVersion.getValue();
    }

    public String getIccid() {
        return iccid.getValue();
    }

    public String getImsi() {
        return imsi.getValue();
    }

    public String getMeterSerialNumber() {
        return meterSerialNumber.getValue();
    }

    public String getMeterType() {
        return meterType.getValue();
    }
}
