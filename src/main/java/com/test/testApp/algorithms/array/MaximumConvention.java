package com.test.testApp.algorithms.array;

public class MaximumConvention {
    public static void main(String[] args) {
        System.out.println(true && false || true && true);// false true true
        System.out.println(max(912318, 112316));
    }

    public static int max(int x, int y) {
        if (x == 0 || y == 0) {
            throw new IllegalArgumentException();
        }
        int min = Math.min(x, y);
        int tail = Math.max(x, y) % min;
        if (tail == 0) {
            return min;
        } else {
            return max(tail, min);
        }
    }
}
