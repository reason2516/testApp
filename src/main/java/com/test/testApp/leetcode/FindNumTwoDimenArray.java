package com.test.testApp.leetcode;

public class FindNumTwoDimenArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int num = 13;
    }

    public static int[] findNum(int[][] arr, int num) {
        int[] ret = null;
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return ret;
        }

        int y = -1;
        int x = -1;
        int yMinIndex = arr[0][0];
        int yMaxIndex = arr.length - 1;
        while (yMaxIndex != yMinIndex) {
            int yMid = (yMinIndex + yMaxIndex) / 2;
            if (arr[(yMid)][0] == num) {
                return new int[]{0, yMid};
            } else if (num > arr[(yMid)][0]) {
                yMinIndex = yMid + 1;
            } else {
                yMaxIndex = yMid - 1;
            }
        }

        return ret;
    }
}
