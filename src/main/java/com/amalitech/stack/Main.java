package com.amalitech.stack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StackSolution solution = new StackSolution();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);

        System.out.println(Arrays.toString(result));
    }
}
