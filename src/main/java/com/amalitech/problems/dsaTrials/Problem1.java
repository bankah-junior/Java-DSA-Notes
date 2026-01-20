package com.amalitech.problems.dsaTrials;

import java.util.Arrays;

public class Problem1 {

    public static void main(String[] args) {


        int[] arr = new int[1000];
        arr[0] = 2;
        arr[1] = 3;
        arr[2] = 4;
        arr[3] = 5;

        for (int i = arr.length -1  ; i > 0; i --) {
            arr[i] = arr[i -1];
        }
        arr[0] = 99;

        System.out.println(Arrays.toString(arr));

        System.out.println(arr[0]);

    }

}
