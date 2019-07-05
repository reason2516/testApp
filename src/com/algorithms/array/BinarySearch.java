package com.algorithms.array;

import com.utils.ArrayUtil;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int length = 100;
        int[] arr = new int[length];
        binarySearch.initArray(arr);
        int rand = (int) (Math.random() * 100) + 100;
        System.out.println("the arr is :\r\n" + ArrayUtil.arrayToString(arr));
        System.out.println("the rand number is :" + rand);
        System.out.println("the rand number index is :" + binarySearch.getIndex(arr, rand));
    }

    public void initArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

    public int getIndex(int[] arr, int rand) {
        int minIndex = 0;
        int maxIndex = arr.length;
        int index = -1;
        while (minIndex < maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;
            if (arr[midIndex] == rand) {
                index = midIndex;
                break;
            } else if (arr[midIndex] > rand) {
                maxIndex = midIndex - 1;
            } else {
                minIndex = midIndex + 1;
            }
        }

        return index;
    }
}
