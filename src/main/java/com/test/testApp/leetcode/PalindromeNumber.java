package com.test.testApp.leetcode;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = 0;
        int temp = x;
        while (x > 0) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        return num == temp;
    }
}
