package com.amalitech.sorting.quick;

public class Main {
    public static void main(String[] args) {

// Input array
        int[] nums = {5, 2, 6, 1};

// Create QuickSort object
        QuickSort quickSort = new QuickSort();


// Call the method
        int result = quickSort.minimumSubarrayDifference(nums, 3);

// Print result
        System.out.println(result);
    }
}