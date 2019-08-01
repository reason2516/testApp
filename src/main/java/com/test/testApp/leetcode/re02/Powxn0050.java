package com.test.testApp.leetcode.re02;

public class Powxn0050 {
    class Solution {
        public double myPow(double x, int n){
            // 这里是关键 防止 -n溢出
            long N = n;

            if(n < 0){
                x = 1/x;
                N = -N;
            }

            return cal(x,N);
        }

        public double cal(double x, long n) {

            if (n == 0) {
                return 1;
            }

            double half = cal(x, n / 2);
            if (n % 2 == 0) {
                return half * half;
            } else {
                return x * half * half;
            }
        }
    }
}
