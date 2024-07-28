package org.sanpang.leetcode.hot;

public class LC11 {
//    https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;
        while ( left < right ) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if ( height[left] <= height[right] ) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;

    }

}
