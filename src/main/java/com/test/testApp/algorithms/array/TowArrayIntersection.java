package com.test.testApp.algorithms.array;

import java.util.*;

public class TowArrayIntersection {
    public static void main(String[] args) {
        int[] a = {7, 8, 9};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> integers = method02(a, b);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    /**
     * 思路 小数组放到 HashSet 遍历大数组比较hashSet中是否已经有值，如果有放到List 算法复杂度 O(m+n)
     *
     * @param a
     * @param b
     * @return
     */
    public static List<Integer> method02(int[] a, int[] b) {

        HashSet<Integer> setA = new HashSet<>();
        for (int i : a) {
            setA.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>(setA.size());
        for (int i : b) {
            if (setA.contains(i)) {
                list.add(i);
            }
        }

        return list;
    }
}
