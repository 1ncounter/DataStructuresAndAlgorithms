package leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        FindFirstAndLastPositionOfElementInSortedArray f = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] r = f.searchRange(nums, target);

        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 0) return result;
        if (target < nums[0]) return result;
        if (target > nums[right]) return result;

        // 查找左边界
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (nums[left] == target) result[0] = left;

        left = 0;
        right = nums.length - 1;

        // 查找右边界
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (nums[right] == target) result[1] = right;

        return result;
    }
}
