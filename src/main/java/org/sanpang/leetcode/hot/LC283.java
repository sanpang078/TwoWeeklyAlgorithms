package org.sanpang.leetcode.hot;

public class LC283 {
    /*
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    请注意 ，必须在不复制数组的情况下原地对数组进行操作。
    示例 1:
    输入: nums = [0,1,0,3,12]
    输出: [1,3,12,0,0]
    */
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int ele: nums) {
            System.out.println(ele);
        }

    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while ( right < n ) {
            if ( nums[right] != 0 ) {
                swap(nums, left, right);
                left ++;
            }
            right ++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}
