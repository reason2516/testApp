package com.test.testApp.leetcode;

class Solution {
    // 思路步骤 1. 归并排序 获取到有序数组 2.奇数偶数判断获取中间值
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int count = len1 + len2;
        int[] numAll = new int[count];

        // 必须进行空数组判断 空数组导致 while循环无法进入
        if (len1 == 0) {
            numAll = nums2;
        }
        if (len2 == 0) {
            numAll = nums1;
        }

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                numAll[k] = nums1[i];
                i++;
            } else {
                numAll[k] = nums2[j];
                j++;
            }
            k++;

            if (i == len1) {
                while (j < len2) {
                    numAll[k] = nums2[j];
                    j++;
                    k++;
                }
            }
            if (j == len2) {
                while (i < len1) {
                    numAll[k] = nums1[i];
                    i++;
                    k++;
                }
            }
        }

        // 偶数个
        if (count % 2 == 0) {
            return (numAll[count / 2 - 1] + numAll[count / 2]) / 2.0;
        } else {
            return numAll[count / 2];
        }
    }
}

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{};
        int[] b = new int[]{1};
        double ret = solution.findMedianSortedArrays(a, b);
        System.out.println(ret);
    }
}
