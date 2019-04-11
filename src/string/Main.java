package string;

public class Main {
    public static void main(String[] args) {
        String s = addBinary("11", "1");

        System.out.println(s);
    }

    private static String addBinary(String a, String b) {
        char ZERO = '0';

        StringBuilder binary = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;

        while (aIndex >= 0 || bIndex >= 0) {
            int numA = aIndex < 0 ? 0 : a.charAt(aIndex) - ZERO;
            int numB = bIndex < 0 ? 0 : b.charAt(bIndex) - ZERO;
            int sum = numA + numB + carry;

            if (sum > 1) {
                carry = sum / 2;
            } else {
                carry = 0;
            }
            sum %= 2;

            binary.insert(0, sum);
            aIndex--;
            bIndex--;
        }

        if (carry == 1) {
            binary.insert(0, 1);
        }

        return binary.toString();
    }
}
