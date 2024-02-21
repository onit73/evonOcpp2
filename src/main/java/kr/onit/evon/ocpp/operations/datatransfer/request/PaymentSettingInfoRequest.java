package kr.onit.evon.ocpp.operations.datatransfer.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentSettingInfoRequest {
    private boolean vat; // 부가세 포함 여부
    private String van; // PG, VAN
    private boolean partialCancelApply; // 부분취소 적용 여부. TRUE 경우 부분취소
    private int partialCancelLocation; // 0: 승승취, 1: 서버에서 취소, 2: 로컬장치에서 취소
    private int maxPrePayPrice; // 최대 선결제 금액
    private int minimumPayPrice; // 최소 결제 금액
    private String paymentSelectionType; // QR, CreditCard, RFID Card
}
