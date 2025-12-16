package com.amalitech.sorting.quick;

class QuickSort {
        public int minimumSubarrayDifference(int[] arrayNumbs, int k) {
            int pivot = quickSelect(arrayNumbs, 0, arrayNumbs.length - 1, k - 1);

            int sumA = 0, sumB = 0;
            boolean pivotUsed = false;

            for (int num : arrayNumbs) {
                if (num < pivot) {
                    sumA += num;
                } else if (num > pivot) {
                    sumB += num;
                } else {
                    if (!pivotUsed) {
                        sumA += num; // temporarily include pivot in A
                        pivotUsed = true;
                    } else {
                        sumA += num; // duplicates treated normally
                    }
                }
            }

            // Decide final pivot placement
            if (sumA > sumB) {
                sumA -= pivot;
                sumB += pivot;
            }

            return Math.abs(sumA - sumB);
        }

        // QuickSelect to find k-th smallest element
        private int quickSelect(int[] nums, int left, int right, int k) {
            if (left == right) return nums[left];

            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == k)
                return nums[pivotIndex];
            else if (pivotIndex < k)
                return quickSelect(nums, pivotIndex + 1, right, k);
            else
                return quickSelect(nums, left, pivotIndex - 1, k);
        }

        private int partition(int[] nums, int left, int right) {
            int pivot = nums[right];
            int i = left;

            for (int j = left; j < right; j++) {
                if (nums[j] <= pivot) {
                    swap(nums, i++, j);
                }
            }
            swap(nums, i, right);
            return i;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
}
