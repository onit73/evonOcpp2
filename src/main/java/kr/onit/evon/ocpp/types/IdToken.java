package kr.onit.evon.ocpp.types;

public class IdToken {
    CiString value;

    public IdToken(String token){
        this(token, CiString.Length.TYPE20);
    }

    public IdToken(String token, CiString.Length length){
        this.value = new CiString(token, length);
    }

    public String getValue(){
        return value.getValue();
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == this )
            return true;
        if( !(obj instanceof IdToken) )
            return false;
        IdToken other = (IdToken) obj;
        return this.value.equals(other.value);
    }

    @Override
    public String toString() {
        return value.getValue();
    }

}
