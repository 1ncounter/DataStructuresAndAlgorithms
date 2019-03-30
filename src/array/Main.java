package array;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};

        int s = pivotIndex(nums);
        System.out.println(s);
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

    public int[] plusOne(int[] digits) {

    }
}
