package com.amalitech.sorting.merge;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();

        int[] nums = {8, 3, 1, 5, 2};
        int[] counts = mergeSort.countSmaller(nums);

        System.out.println(Arrays.toString(counts));
    }
}
