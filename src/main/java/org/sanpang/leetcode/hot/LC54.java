package org.sanpang.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public static void main(String[] args) {
        int m = 3;
        int n = 1;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = i * matrix[0].length + j + 1;
            }
        }
        printMatrix(matrix);

        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);

    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0, rowEnd = matrix.length - 1, fieldStart = 0, fieldEnd = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
        while ( rowStart <= rowEnd && fieldStart <= fieldEnd ) {
            circle(rowStart, rowEnd, fieldStart, fieldEnd, list, matrix);
            rowStart += 1;
            rowEnd -= 1;
            fieldStart += 1;
            fieldEnd -= 1;
        }
        return list;
    }

    private static void circle(int rowStart, int rowEnd, int fieldStart, int fieldEnd, List<Integer> list, int[][]matrix) {
        for (int i = fieldStart;i <= fieldEnd; i++) {
            list.add(matrix[rowStart][i]);
        }

        for (int i = rowStart + 1; i <= rowEnd; i++) {
            list.add(matrix[i][fieldEnd]);
        }

        for (int i = fieldEnd - 1; i >= fieldStart; i--) {
            if (rowStart != rowEnd) list.add(matrix[rowEnd][i]);
        }

        for (int i = rowEnd - 1; i > rowStart ; i--) {
            if (fieldStart != fieldEnd) list.add(matrix[i][fieldStart]);
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
