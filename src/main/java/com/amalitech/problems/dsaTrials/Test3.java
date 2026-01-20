package com.amalitech.problems.dsaTrials;

public class Test3 {

    public static int SlidingWindow(int[] arr, int k){

//        int entering = 0;
//        int leaving  =0;


//        edge case
        if(arr.length < k){
            return -1;
        }

//        First window
        int tempSum = 0;

        for(int i = 0; i<k ; i++){
            tempSum += arr[i];
        }

        int maxSum = tempSum;

        //        Sliding
        for(int i = k; i<arr.length ; i++ ){
            tempSum =+ arr[i] - arr[i-k];
            if(tempSum > maxSum){
                maxSum = tempSum;
            }

        }





        return maxSum;
    };


    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20}; // 17, 18, 17, 16, 6, 24
        int size = 4;
        System.out.println(SlidingWindow(arr, size));
    }
}
