package com.amalitech.problems.dsaTrials;

public class MatrixTraversal {

    public static int SumDiagonalElement(int[][] arr){
        int tempSum = 0;

        for (int row = 0; row<arr.length; row ++){
           for (int column = 0; column<arr[row].length; column ++){

               if(row == column){
                   tempSum+= arr[row][column];
               }
           }
        }

        return tempSum;

    };

    public static void main(String[] args) {
        int[][] myArr = {
                {2,3},
                {5,6,7},
//                {8,9,1}
        };

        System.out.println(SumDiagonalElement(myArr));
        System.out.println(myArr.length);
    }
}
