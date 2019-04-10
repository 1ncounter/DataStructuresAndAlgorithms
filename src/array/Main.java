package array;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int[] nums = {9};

        int[] s = plusOne(nums);
        System.out.println(Arrays.toString(s));
    }

    /**
     * 数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     * @param nums 整数类型的数组
     * @return 中心索引
     */
    public static int pivotIndex(int[] nums) {
        int total = 0;
        int leftTotal = 0;
        int half = 0;

        for(int num: nums) {
            total += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftTotal == total - leftTotal - nums[i]) {
                return i;
            }
            leftTotal += nums[i];
        }
        return -1;
    }

    /**
     * 在一个给定的数组nums中，总是存在一个最大元素 。
     * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍.
     * 如果是，则返回最大元素的索引，否则返回-1。
     */
    public static int dominantIndex(int[] nums) {
        int max1 = -1;
        int max2 = -1;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max1 = nums[i];
                max2 = max1;
                maxIndex = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }

        return max1 > 2 * max2 ? maxIndex : -1;
    }

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * @param digits int[]
     * @return int[]
     */
    public static int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;

        int carry = 1;
        int len = digits.length;

        for (int i = len - 1; i >= 0; i--) {
            if (carry == 0) return digits;

            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        int[] res = new int[len + 1];
        res[0] = 1;

        return carry == 0 ? digits : res;
    }

    /**
     * 对角线遍历
     * @param matrix 二位数组
     * @return 一维数组
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;
        int[] order = new int[m * n];
        int row = 0;
        int col = 0;
        int d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};

        for (int i = 0; i < m * n; i++) {
            order[i] = matrix[row][col];
            row += dirs[d][0];
            col += dirs[d][1];

            if (row >= m) {
                row = m - 1;
                col += 2;
                d = 1 - d;
            }
            if (col >= n) {
                col = n - 1;
                row += 2;
                d = 1 - d;
            }
            if (row < 0) {
                row = 0;
                d = 1 - d;
            }
            if (col < 0) {
                col = 0;
                d = 1 - d;
            }
        }

        return order;
    }
}
