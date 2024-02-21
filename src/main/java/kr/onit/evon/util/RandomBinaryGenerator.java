package kr.onit.evon.util;

import javax.websocket.Decoder;
import java.math.BigInteger;
import java.util.Random;

public class RandomBinaryGenerator {

    public static String randomBinaryHex(int n)
    {
        if (n <= 0)
            return "";

        Random rand = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; ++i)
            result.insert(0, Math.abs(rand.nextInt() % 2));
        return new BigInteger(result.toString(), 2).toString(16);
    }
}
