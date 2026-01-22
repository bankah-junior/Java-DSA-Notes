package com.amalitech.sorting.quick;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortLomuto {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int p = partition(arr, lo, hi);   // lomuto
        quickSort(arr, lo, p - 1);
        quickSort(arr, p + 1, hi);
    }

    // Lomuto partition: pivot is arr[hi]
    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo; // position to place next smaller element
        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) { // <= keeps duplicates near pivot
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, hi);
        return i; // pivot final index
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 1, 4, 8, 2, 6, 5};
        quickSort(arr);
        System.out.println("Lomuto: " + Arrays.toString(arr));
    }
}
