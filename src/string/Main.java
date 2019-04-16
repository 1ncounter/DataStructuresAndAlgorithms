package string;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[] s = {'H', 'a', 'n', 'q', 'n', 's'};
        reverseString(s);
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

    private static int strStr(String haystack, String needle) {
        if (needle.isEmpty() || haystack.equals(needle)) return 0;
        if (haystack.isEmpty() || haystack.length() < needle.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (needle.charAt(0) == haystack.charAt(i)) {
                if (needle.equals(haystack.substring(i, i + needle.length()))) {
                    return i;
                }
            }
        }
        return  -1;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String pre = strs[0];

        for (int i = 1; i <= strs.length; i++) {
            while (strs[i].indexOf(pre) != 0 && pre.length() > 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }

    public static void reverseString(char[] s) {
        if (s.length == 0) return;
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char t = s[left];
            s[left++] = s[right];
            s[right--] = t;
        }
    }

    /**
     * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for(int i = 0;i < nums.length;i = i + 2){
            sum = sum + nums[i];
        }

        return sum;
    }

    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = 0;
        int[] result = new int[2];

        while (start < end) {
            int temp = nums[start] + nums[end];

            if (temp == target) {
                result[0] = start;
                result[1] = end;
                return result;
            } else if (temp < target) {
                // 如果相加小于target 说明start处太小！因为end已经是最大的了
                int t = nums[start];
                start++;
                while (t == nums[start]) {
                    // 优化在于去除与start相等的值
                    start++;
                }
            } else {
                int t = nums[end];
                end--;
                while (t == nums[end]) {
                    end--;
                }
            }
        }

        return result;
    }
}
