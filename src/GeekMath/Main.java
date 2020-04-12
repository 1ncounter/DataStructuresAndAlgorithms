package GeekMath;



public class Main {
    public static void main(String[] args) {
        int a = 53;
        String b = "10011110";

        System.out.println(String.format(" 数字 %d 的二进制是 %s", a, Binary.decimalToBinary(a)));
        System.out.println(String.format(" 数字 %s 的十进制是 %d", b, Binary.binaryToDecimal(b)));
    }
}
