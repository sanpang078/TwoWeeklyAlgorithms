package org.sanpang.leetcode.hot;

public class LC73 {
    public static void main(String[] args) {

        /*https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked*/
        int[][] matrix = new int[5][4];
        for ( int i = 0; i < matrix.length; i++ ) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 1;
            }
        }

        matrix[1][1] = 0;
        matrix[2][0] = 0;
        matrix[3][1] = 0;
        matrix[4][3] = 0;

        printMatrix(matrix);

        setZeroes(matrix);

        printMatrix(matrix);


    }

    //原地算法
    public static void setZeroes(int[][] matrix) {

        boolean flagcol0 = false, flagRow0 = false;

        for ( int i = 0; i < matrix.length; i++ ) {
            if ( matrix[i][0] == 0) flagcol0 = true;
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if ( matrix[0][j] == 0) flagRow0 = true;
        }

        for ( int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if ( matrix[i][j] == 0 ) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for ( int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if ( matrix[i][0] == 0 || matrix[0][j] == 0 ) {
                    matrix[i][j] = 0;
                }
            }
        }

        if ( flagcol0 ) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if ( flagRow0 ) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

    }

    public static void printMatrix(int[][] matrix) {
        for ( int i = 0; i < matrix.length; i++ ) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("=============");
    }
}
