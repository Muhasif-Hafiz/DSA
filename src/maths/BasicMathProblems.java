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
         System.out.println( countDigitsBruteForce(36));


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
    static int gcd(int n1, int n2){
        int limit = Math.max(n1, n2);
        int hcf =0;

        for(int i=1;i<= limit;i++){
            if(n1 % i==0 && n2%i ==0){
                hcf = i;
            }
        }

        return hcf;
    }

    static  boolean isArmstrongNumber(int num){
         /*

          T.C ->  log10(num)

         */
        int oldNum = num;
        int numSize = (int)Math.log10(num)+1;
        int newNum =0;
        while(num != 0){
            int digit = num %10;
            newNum += Math.pow(digit, numSize);
            num/=10;
        }

        return oldNum ==newNum;
    }
    static ArrayList printDivisors(int num){
        ArrayList list = new ArrayList<>();

        for(int i=1;i<=num;i++){
            if(num % i ==0){
                list.add(i);
            }

        }
        return list;
    }
    static  ArrayList printDivisorsOptimised(int num){
        ArrayList list = new ArrayList<>();

        for(int i=1;i*i<=num;i++){
            if(num % i ==0){
                if(i == num/i){
                    list.add(i);
                }else{
                    list.add(i);
                    list.add(num/i);
                }
            }
        }
        return list;
    }


}




