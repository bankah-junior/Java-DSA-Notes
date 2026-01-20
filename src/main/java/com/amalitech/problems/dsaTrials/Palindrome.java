package com.amalitech.problems.dsaTrials;

import java.util.Locale;

public class Palindrome {

    public static boolean isPalindrome(String s){

//        s.toLowerCase();
        int left = 0;
        int right  = s.length() -1;
//Madam
        while (left < right){
            if (s.charAt(left) == s.charAt(right)) {
                left ++;
                right --;

                if (left == right){
                    return true;
                }
            } else return false;
        }



        return false;

    };

    public static void main(String[] args) {
        boolean result = isPalindrome("level".toLowerCase());
        System.out.println(result);
    }
}
