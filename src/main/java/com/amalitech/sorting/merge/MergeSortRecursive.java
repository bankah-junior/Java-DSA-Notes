package com.amalitech.sorting.merge;

import java.util.Arrays;

public class MergeSortRecursive {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int[] temp = new int[arr.length]; // auxiliary buffer
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) return; // base case: 1 element

        int mid = left + (right - left) / 2;

        // Sort left half and right half
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);

        // Optimization: if already ordered, skip merge
        if (arr[mid] <= arr[mid + 1]) return;

        // Merge sorted halves
        merge(arr, left, mid, right, temp);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // Copy the range we will merge into temp
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;      // pointer for left half
        int j = mid + 1;   // pointer for right half
        int k = left;      // write pointer in original array

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        // Copy remaining left half (right half already in place if any)
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        // No need to copy the right half; it's already placed due to temp copy
    }

    // Demo
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 5, 5, 6, 9]
    }
}