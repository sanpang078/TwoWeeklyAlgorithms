package org.sanpang.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

public class LC46 {
    /*https://leetcode.cn/problems/permutations/description/?envType=study-plan-v2&envId=top-100-liked
    * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
        示例 1：
        输入：nums = [1,2,3]
        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        示例 2：
        输入：nums = [0,1]
        输出：[[0,1],[1,0]]
        示例 3：
        输入：nums = [1]
        输出：[[1]]
    * */
    public static void main(String[] args) {
        int[] nums = new int[]{127, 128, 129};
        List<List<Integer>> lists = permute(nums);
        for ( List<Integer> list: lists ) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(nums, lists, list);
        return lists;
    }

    public static void solve(int[] nums, List<List<Integer>> lists, List<Integer> list) {
        if (list.size() == nums.length) {
            ArrayList<Integer> newList = new ArrayList<>(list);
            lists.add(newList);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            if ( !list.contains(num)) {
                list.add(num);
                solve( nums, lists, list );
                list.remove(num);
            }
        }
    }
}
