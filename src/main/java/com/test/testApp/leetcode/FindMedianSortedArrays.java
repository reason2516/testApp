package com.test.testApp.leetcode;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double mid;
        int[] numbsTemp = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                numbsTemp[k] = nums1[i];
                i++;
            } else {
                numbsTemp[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < nums1.length) {
            numbsTemp[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            numbsTemp[k] = nums2[j];
            j++;
            k++;
        }

        if (numbsTemp.length % 2 == 1) {
            mid = numbsTemp[numbsTemp.length / 2];
        } else {
            mid = ((double) numbsTemp[numbsTemp.length / 2 - 1] + (double) numbsTemp[numbsTemp.length / 2]) / 2;
        }

        return mid;
    }


    public static void main(String[] args) {
        double mid = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(mid);
    }
}
