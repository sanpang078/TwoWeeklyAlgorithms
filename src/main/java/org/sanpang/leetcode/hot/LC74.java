package org.sanpang.leetcode.hot;

public class LC74 {
/*https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-100-liked
* 给你一个满足下述两条属性的 m x n 整数矩阵：

每行中的整数从左到右按非严格递增顺序排列。
每行的第一个整数大于前一行的最后一个整数。
给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
示例 1：
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
输出：true
示例 2：
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
输出：false*/
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},
                          {10, 11, 16, 20},
                          {23, 30, 34, 60}
                         };
//        System.out.println(searchRow(matrix,30));
        System.out.println(searchMatrix(matrix, 0));

    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = searchRow(matrix, target);
        if ( row == -1 ) return false;
        int n = matrix[row].length;
        boolean ans = false;
        int left = 0;
        int right = n - 1;
        while ( left <= right ) {
            int mid = left + (right - left) / 2;
            if ( matrix[row][mid] == target ) {
                ans = true;
                break;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static int searchRow(int[][] matrix, int target) {
        int m = matrix.length;
        int down = 0;
        int up = m - 1;
        int row = -1;

        while ( down <= up) {
            int mid = down + (up - down) / 2;
            int midVal = matrix[mid][0];
            if ( midVal == target ) {
                row = mid;
                break;
            } else if (midVal < target) {
                row = mid;
                down = mid + 1;
            } else {
                up = mid - 1;
            }
        }
        return row;

    }
}
