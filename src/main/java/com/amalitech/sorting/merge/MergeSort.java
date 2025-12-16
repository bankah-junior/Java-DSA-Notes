package com.amalitech.sorting.merge;

class MergeSort {
        private static class Pair {
            int value;
            int index;

            Pair(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }

        public int[] countSmaller(int[] nums) {
            int n = nums.length;
            int[] counts = new int[n];

            Pair[] arr = new Pair[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new Pair(nums[i], i);
            }

            mergeSort(arr, 0, n - 1, counts);
            return counts;
        }

        private void mergeSort(Pair[] arr, int left, int right, int[] counts) {
            if (left >= right) return;

            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid, counts);
            mergeSort(arr, mid + 1, right, counts);
            merge(arr, left, mid, right, counts);
        }

        private void merge(Pair[] arr, int left, int mid, int right, int[] counts) {
            Pair[] temp = new Pair[right - left + 1];

            int i = left;
            int j = mid + 1;
            int k = 0;
            int rightSmallerCount = 0;

            while (i <= mid && j <= right) {
                if (arr[i].value <= arr[j].value) {
                    counts[arr[i].index] += rightSmallerCount;
                    temp[k++] = arr[i++];
                } else {
                    rightSmallerCount++;
                    temp[k++] = arr[j++];
                }
            }

            while (i <= mid) {
                counts[arr[i].index] += rightSmallerCount;
                temp[k++] = arr[i++];
            }

            while (j <= right) {
                temp[k++] = arr[j++];
            }

            System.arraycopy(temp, 0, arr, left, temp.length);
        }
}
