package com.wjp.problems.collection;

public class Solution {
    public static void main(String[] args) {

//        int[] arr = new int[]{5, 23, 6, 112, 44, 33, 31};
        int[] arr = new int[100];
       //


        System.out.println(new Solution().max(arr));
        System.out.println(count);
    }

    int max(int[] arr) {
        return max(arr, arr.length - 1);
    }

    static int count = 0;

    int max(int[] arr, int end) {
        System.out.printf("max: %s %s \n", 0, end);
        if (end == 0) {
            return arr[0];
        }

        int i = 0, j = end;
        while (i < j) {
            if (arr[i] < arr[j]) {
                System.out.printf("compare %s, %s\n", i, j);
                swap(arr, i, j);
            }
            count++;
            i++;
            j--;

        }
        int newEnd = i == j ? i : i - 1;
        return max(arr, newEnd);
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
