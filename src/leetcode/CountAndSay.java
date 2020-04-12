package leetcode;

public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();

        System.out.println(countAndSay.countAndSay(4));
    }

    public String countAndSay(int n) {
        String[] dp = new String[n];
        dp[0] = "1";
        StringBuilder sb;

        for (int i = 1; i < n; i++) {
            int count = 1;
            sb = new StringBuilder();
            char[] ss = dp[i - 1].toCharArray();
            int len = ss.length;

            for (int j = 0; j < len - 1; j++) {
                if (ss[j] == ss[j + 1]) {
                    count++;
                    continue;
                }
                sb.append(count).append(ss[j]);
                count = 1;
            }

            sb.append(count).append(ss[len - 1]);
            dp[i] = sb.toString();
        }

        return dp[n - 1];
    }
}