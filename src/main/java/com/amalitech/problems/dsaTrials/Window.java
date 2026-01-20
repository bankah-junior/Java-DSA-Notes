package com.amalitech.problems.dsaTrials;

public class Window {



    public static int SlidingWindow(int[] arr, int k){
        int entering  = 0;
        int leaving = k;
        int sum = 0;

//        {1,2,3,4,5.6.7} ... k = 4
        int tempSum = 0;

        while (leaving <= arr.length) {

            for (int i = entering; i < leaving; i++) {
                tempSum += arr[i];

                if (i == leaving-1){
                    if (tempSum > sum)
                        sum = tempSum;
                    tempSum = 0;
                    entering ++;
                    leaving ++;
                }
            }

        }


        return sum;
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20}; // 17, 18, 17, 16, 6, 24
        int size = 4;
        System.out.println(SlidingWindow(arr, size));

    }
}
