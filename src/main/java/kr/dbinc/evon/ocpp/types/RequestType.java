package kr.dbinc.evon.ocpp.types;

public interface RequestType {

    static String extractAction(RequestType requestType){
        String requestName = requestType.getClass().getSimpleName();
        return requestName.substring(0, requestName.length() - "Request".length());
    }
}
