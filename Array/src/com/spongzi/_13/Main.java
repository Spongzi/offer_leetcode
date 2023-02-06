package com.spongzi._13;

/**
 * 剑指 Offer II 013. 二维子矩阵的和
 * <a href="https://leetcode.cn/problems/O4NDxx/?favorite=e8X3pBZi"></a>
 *
 * @author spong
 * @date 2023/02/06
 */
public class Main {
}

class NumMatrix {
    int[][] sums;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                rowSum += matrix[i][j];
                sums[i + 1][j + 1] = sums[i][j + 1] + rowSum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1]
                - sums[row2 + 1][col1] + sums[row1][col1];
    }
}
