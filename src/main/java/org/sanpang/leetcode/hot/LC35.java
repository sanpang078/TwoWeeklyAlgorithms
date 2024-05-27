package org.sanpang.leetcode.hot;

public class LC35 {

    /*https://leetcode.cn/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-100-liked
    *给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    请必须使用时间复杂度为 O(log n) 的算法。
    示例 1:
    输入: nums = [1,3,5,6], target = 5
    输出: 2
    示例 2:
    输入: nums = [1,3,5,6], target = 2
    输出: 1
    示例 3:
    输入: nums = [1,3,5,6], target = 7
    输出: 4
    * nums 为 无重复元素 的 升序 排列数组
    * */

    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 6};
        int[] nums = {1, 3};
        System.out.println(searchInsert(nums, 3));
    }
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;
        if ( target > nums[end] ) return nums.length;
        if ( target < nums[start] ) return start;
        while ( start <= end ) {
            int cur = start + (end - start) / 2;
            if ( nums[cur] == target ) {
                res = cur;
                break;
            } else if (nums[cur] < target) {
                if ( nums[cur + 1] > target ) {
                    res = cur + 1;
                    break;
                }
                start = cur + 1;
            } else if (nums[cur] > target) {
                if ( nums[cur - 1] < target ) {
                    res = cur;
                    break;
                }
                end = cur - 1;
            }
        }
        return res;
    }

}
