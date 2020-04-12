package GeekMath;

import java.math.BigInteger;

public class Binary {
    /**
     * 十进制转换成二进制
     * @param decimalSource 二进制
     * @return String
     */
    public static String decimalToBinary(int decimalSource) {
        BigInteger bi = new BigInteger(String.valueOf(decimalSource));
        return bi.toString();
    }

    /**
     * 二进制转换成十进制
     * @param binarySource 二进制数
     * @return int
     */
    public static int binaryToDecimal(String binarySource) {
        BigInteger bi = new BigInteger(binarySource, 2);
        return Integer.parseInt(bi.toString());
    }
}
