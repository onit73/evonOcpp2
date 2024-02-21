package kr.onit.evon.ocpp.operations.datatransfer;

public abstract class DataTransferMessage {

    public static final String PAYMENT_INFO = "PayInfo";
    public static final String STOP_TRANSACTION_SUB_INFO = "StopTransactionSubInfo";

    public static final String GET_PRICE = "GetPrice";
    public static final String GET_PRICING_PROFILE = "GetPricingProfile";

    public static final String GET_ID_TAG_PROFILE = "GetIdTagProfile";

    public static final String PAYMENT_AUTH_INFO = "PaymentAuthInfo";
    public static final String PARTIAL_CANCEL = "PartialCancel";

    public static final String RESULT_PRICE = "ResultPrice";
    public static final String PRICE_PER_TIME = "PricePerTime";

    public static final String SMS_MESSAGE = "SmsMessage";

//    public static final String PARTIAL_CANCEL = "PartialCancel";

}
