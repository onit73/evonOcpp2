package kr.dbinc.evon.ocpp.types;

import java.util.Objects;

import kr.dbinc.evon.ocpp.rpc.exception.PropertyConstraintViolationException;

public class CiString{
    private final String value;
    private final Length size;

    public CiString(String value, Length size){
        value = value != null ? value : "";
        lengthCheck(value, size);
        this.value = value;
        this.size = size;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("CiString{value=%s, length=%d", value, size.getValue());
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * Integer.hashCode(size.getValue());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == this)
            return true;
        if( !(obj instanceof CiString))
            return false;
        CiString other = (CiString) obj;
        return this.value.equalsIgnoreCase(other.value)
                && this.size == other.size;
    }

    public enum Length{
        TYPE20(20),
        TYPE25(25),
        TYPE50(50),
        TYPE255(255),
        TYPE500(500);

        private final int value;

        Length(int size) {
            this.value = size;
        }

        private int getValue(){
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }


    private void lengthCheck(String token, Length length){
        if(token.length() > length.value)
            throw new PropertyConstraintViolationException(String.format("문자열의 길이는 %d자를 초과 할 수 없습니다. 현재 문자열 길이는 [%d]입니다", length.value, token.length()));
    }
}
