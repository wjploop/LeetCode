package com.wjp.sorts;

import sorts.UtilsKt;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{ 3, 2, 6, 5, 4, 1, 3,};
        UtilsKt.println(arr);
        quickSort(arr, 0, arr.length - 1);
        UtilsKt.println(arr);
    }

    static void quickSort(int[] arr, int start, int end) {
        if(start >= end){
            return ;
        }
        int i = start, j = end;
        // 将中轴取出来，将其保存至变量pivot,随之arr[i]这个坑空出来了
        int pivot = arr[i];
        while (i < j) {
            // 从右往左寻找第一个比中轴小的数，找到其
            while (i < j && arr[j] >pivot) {
                j--;
            }
            // 同样，从左边开始，寻找第一个比中轴大的元素
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            System.out.println("i " + i + ", j " + j);

//            if (arr[i] == arr[j] && i < j) {
//                // 若是找打两个数都等于pivot
//                // 则从i开始继续右移寻找比pivot大数
//                i++;
//            }else{
                // 否则交换两个数 i,j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
//            }
        }
        // 此时i == j
        UtilsKt.println(arr);
        arr[i] = pivot;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }
}
