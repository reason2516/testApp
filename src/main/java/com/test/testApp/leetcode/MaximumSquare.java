package com.test.testApp.leetcode;

public class MaximumSquare {
    /**
     * 求最大公约数？ 辗转相除法的论证？
     * 给定一个 边长为x，y 的长方形 切分成正方形不留余料（要求正方形的边长要足够大）
     * 分而治之思想
     *
     * @param x
     * @param y
     * @return
     */
    public int solution(int x, int y) {

        int max = Math.max(x, y);
        int min = Math.min(x, y);
//        if (x > y) {
//            max = x;
//            min = y;
//        } else {
//            max = y;
//            min = x;
//        }
        if (max % min == 0) {
            return min;
        } else {
            return this.solution(max % min, min);
        }

    }

    public static void main(String[] args) {
        MaximumSquare maximumSquare = new MaximumSquare();
        int solution = maximumSquare.solution(400, 300);
        System.out.println(solution);
    }
}
