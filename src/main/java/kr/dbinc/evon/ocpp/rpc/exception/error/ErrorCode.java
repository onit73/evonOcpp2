package kr.dbinc.evon.ocpp.rpc.exception.error;

public enum ErrorCode {
    NotImplemented("요청한 작업을 알 수 없음"),
    NotSupported("액션이 인식은 되지만 지원되지 않음"),
    InternalError("내부 오류가 발생해 요청된 작업을 처리할 수 없음"),
    ProtocolError("액션에 대한 페이로드가 불완전함"),
    SecurityError("작업 처리 중 보안 문제가 발생하여 작업을 성공적으로 완료할 수 없음 "),
    FormationViolation("액션용 페이로드가 구문적으로 잘못되었거나 액션용 PDU가 구조를 준수하지 않음"),
    PropertyConstraintViolation("페이로드가 구문적으로는 올바르지만 하나 이상의 필드에 잘못된 값이 포함"),
    OccurenceConstraintViolation("액션에 대한 페이로드가 구문적으로는 올바르지만 필드 중 하나 이상이 occurence constraints를 위반함 "),
    TypeConstraintViolation("액션용 페이로드가 구문적으로는 올바르지만 필드 중 하나 이상이 데이터 형식 제약 조건을 위반"),
    GenericError("앞의 에러들로 처리되지 않는 기타 에러");


    private final String description;

    ErrorCode(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
