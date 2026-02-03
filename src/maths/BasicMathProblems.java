package maths;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicMathProblems {

     static void main(String[] args) {
        // int digits = countDigitsBruteForce(12345);
        // int digits = countDigitsOptimal(0);
         //System.out.println("The Number of digits are : " + digits);

        // int number = reversedNumberOptimised(10400);

        // boolean isPalindrome = isNumberPalindrome(1122311);
         //System.out.println(Arrays.toString(printDivisors(6)));
        // System.out.println( printDivisors(1000));


    }

    static  int countDigitsBruteForce(int n){
         // Brute Force Approach
        // T.C -> 0(N)

         if(n==0) return 1;
         int count =0;
         while(n>0){
             n /=10;
             count++;
         }
         return count;
    }

    static int countDigitsOptimal(int num){
      /* Explanation  :
      *
      * log10(num) means ' to What power we raise 10 so that it becomes the number
      * that means log10(10^k) = k
      *
      * Expression	Meaning	Result
        log10(10)	10¹ = 10	1
        log10(100)	10² = 100	2
        log10(1000)	10³ = 1000	3
      *
      *
      * */
        if(num==0) return 1;
        return  (int) Math.log10(  num) +1;
    }
    static int reversedNumberOptimised(int num){
        // T.C -> 0(log10(num) // because the number of iterations depends upon the number of digits we have.

        if(num >= Integer.MAX_VALUE) return 0;

        if(num == 0) return  0;
        int newNum =0;
        while(num > 0){
            int lst = num %10;
            newNum = (newNum * 10) + lst;
            num /= 10;
        }
        return newNum;
    }
    static boolean isNumberPalindrome(int num){
        return num == reversedNumberOptimised(num);
    }




}




