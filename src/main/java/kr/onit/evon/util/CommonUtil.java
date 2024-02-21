package kr.onit.evon.util;

import kr.onit.evon.util.me.MeChargerInfo;

public class CommonUtil {
    public static MeChargerInfo convertToMeType(String chargeId){
        //String formatted = String.format("%08d", chargeId);
        String sid = chargeId.substring(0, 3);
        String cid = chargeId;

        return new MeChargerInfo(sid, cid);
    }


    public static String removeLeadingZeroPrefix(String value){
        return value.replaceFirst("^0+(?!$)", "");
    }
}
