package com.amalitech.queue;

public class Main {
    public static void main(String[] args) {
        QueueSolution solution = new QueueSolution();
        int[][] grid01 = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        int[][] grid02 = {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };
        int result01 = solution.orangesRotting(grid01);
        System.out.println("Minutes until all oranges rot: " + result01);
        int result02 = solution.orangesRotting(grid02);
        System.out.println("Minutes until all oranges rot: " + result02);
    }
}
