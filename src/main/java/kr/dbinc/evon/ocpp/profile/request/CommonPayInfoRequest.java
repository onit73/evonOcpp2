
package kr.dbinc.evon.ocpp.profile.request;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import kr.dbinc.evon.ocpp.operations.datatransfer.request.PartialCancelRequest;
import kr.dbinc.evon.ocpp.operations.datatransfer.request.PaymentInfoRequest;
import kr.dbinc.evon.ocpp.operations.datatransfer.request.SignetPartialCancelRequest;
import kr.dbinc.evon.ocpp.operations.datatransfer.request.SignetPaymentAuthInfoRequest;
import kr.dbinc.evon.util.me.MeChargerInfo;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommonPayInfoRequest { // u1

    private String authAmount;
    private String authDate;
    private String authTime;
    private String authNo;
    private String transactionNo;
    private String payResult;
    private String orgTransactionNo;
    private String orgAuthNo;
    private String payType; // 0: 원결제, 1: 재정산결제(부분취소), 2: 재정산결제(재승인), 3: 원결제취소
    private String dealCode;
    private String vanPgType;
    private String storeNo;
    private String mid;
    private String acquirer;
    private String maskingPinNumber;
    private String issueCompany;
    private String sid;
    private String cid;
    private String chargerState;
    private String chargerMode;
    private String useWh;
    /*
    public static CommonPayInfoRequest of(PaymentInfoRequest infoRequest, MeChargerInfo info) {
        return CommonPayInfoRequest.builder()
                .authAmount(String.valueOf(infoRequest.getAuthAmount()) )
                .authDate(infoRequest.getAuthDate())
                .authTime(infoRequest.getAuthTime())
                .authNo(infoRequest.getAuthNo())
                .transactionNo(infoRequest.getTransactionNo())
                .payResult("1")
                .orgTransactionNo("")
                .orgAuthNo("")
                .payType("0")
                .dealCode("1")
                .vanPgType("1")
                .storeNo("00000000000000")
                .mid("00000000000000")
                .acquirer("00000000000000")
                .maskingPinNumber("00000000000000")
                .issueCompany("00000000000000")
                .sid(info.getSid())
                .cid(info.getCid())
                .build();
    }

    public static CommonPayInfoRequest of(SignetPaymentAuthInfoRequest authInfoRequest, MeChargerInfo info) {
        return CommonPayInfoRequest.builder()
                .authAmount(authInfoRequest.getAuthAmount())
                .authDate(authInfoRequest.getTransactionDate())
                .authTime(authInfoRequest.getTransactionTime())
                .authNo(authInfoRequest.getApprovalNum())
                .transactionNo(authInfoRequest.getTransactionNum())
                .payResult("1")
                .orgTransactionNo("")
                .orgAuthNo("")
                .payType("0")
                .dealCode("1")
                .vanPgType("1")
                .storeNo(authInfoRequest.getMarketNum())
                .mid("00000000000000")
                .acquirer("00000000000000")
                .maskingPinNumber("00000000000000")
                .issueCompany("00000000000000")
                .sid(info.getSid())
                .cid(info.getCid())
                .build();
    }

    public static CommonPayInfoRequest of(SignetPartialCancelRequest cancelRequest, MeChargerInfo meInfo, SignetPaymentAuthInfoRequest payContext) {
        LocalDateTime timestamp = cancelRequest.getTimestamp();
        return CommonPayInfoRequest.builder()
                .authAmount(String.valueOf((int)cancelRequest.getSessionFee()))
                .authDate(String.format("%d%d%d", timestamp.getYear(),timestamp.getMonthValue(),timestamp.getDayOfMonth()))
                .authTime(String.format("%02d%02d%02d", timestamp.getHour(), timestamp.getMinute(), timestamp.getSecond()))
                .authNo("")
                .transactionNo(cancelRequest.getPgTransactionNum())
                .payResult("1")
                .orgTransactionNo(payContext.getTransactionNum())
                .orgAuthNo(payContext.getApprovalNum())
                .payType("1")
                .dealCode("1")
                .vanPgType("1")
                .storeNo(payContext.getMarketNum())
                .mid("00000000000000")
                .acquirer("00000000000000")
                .maskingPinNumber("00000000000000")
                .issueCompany("00000000000000")
                .sid(meInfo.getSid())
                .cid(meInfo.getCid())
                .build();
    }

    public static CommonPayInfoRequest of(PartialCancelRequest cancelRequest, MeChargerInfo meInfo, PaymentInfoRequest payContext) {
        return CommonPayInfoRequest.builder()
                .authAmount(String.valueOf(cancelRequest.getAuthAmount()))
                .authDate(cancelRequest.getAuthDate())
                .authTime(cancelRequest.getAuthTime())
                .authNo("")
                .transactionNo(cancelRequest.getTransactionNo())
                .payResult("1")
                .orgTransactionNo(payContext.getTransactionNo())
                .orgAuthNo(payContext.getAuthNo())
                .payType("1")
                .dealCode("1")
                .vanPgType("1")
                .storeNo("00000000000000")
                .mid("00000000000000")
                .acquirer("00000000000000")
                .maskingPinNumber("00000000000000")
                .issueCompany("00000000000000")
                .sid(meInfo.getSid())
                .cid(meInfo.getCid())
                .build();
    }
 */
}
