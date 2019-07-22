package com.test.testApp.algorithms.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 求两个数组交集
 */
public class TwoArrayCrossUnion {
    public static void main(String[] args) {
        int[] intA = {1, 2, 3, 4, 5, 6, 7};
        int[] intB = { 2, 5, 6, 8, 11, 12};
        List<Integer> integers = method01(intA, intB);
        for (Integer item : integers) {
            System.out.println(item);
        }
    }

    /**
     * 思路 利用 HashSet 无重复元素 算法复杂度 O(m+n)
     *
     * @param a
     * @param b
     * @return
     */
    public static List<Integer> method01(int[] a, int[] b) {

        HashSet<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        for (int i : b) {
            set.add(i);
        }


        return new ArrayList<>(set);
    }
}
