package leetcode;

import java.util.List;
import java.util.ArrayList;

public class Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Permute permute = new Permute();
        System.out.println(permute.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 0) {
            return res;
        }

        boolean[] used = new boolean[nums.length];

        dfs(nums, 0, new ArrayList<>(), used, res);
        return res;
    }

    private void dfs(int[] nums, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, depth + 1, path, used, res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
