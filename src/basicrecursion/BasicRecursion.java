package basicrecursion;

import java.util.Arrays;

public class BasicRecursion {
    static  void main(String[] arr){

        //printNTimes(10);
        //printReverseNumbers(10);
        //System.out.println(sumOfNNumbers(100));
      //  System.out.println(factorial(10));

//        int [] arr= {0,1,2,3,4,5,6,7,8,9};
//        reverseArray(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(arr));
//        String s= "xxa";
//        System.out.println(isStringPalindrome(s, 0));
        System.out.println(fibonacciNumber(50));

    }
    static void printNTimes(int n){
        if(n==0){
            System.out.println(n);
            return;
        }
        printNTimes(n-1);
        System.out.println(n);
    }
    static void printReverseNumbers(int n){
        if(n==0) return;
        System.out.println(n);
        printReverseNumbers(n-1);
    }
    static  int sumOfNNumbers(int n){
        if(n==0) return 0;
        return n + sumOfNNumbers(n-1);
    }
    static int factorial(int n){
        if(n==0 || n==1) return 1;
        return n *factorial(n-1);
    }
    static int [] reverseArray(int [] arr, int i, int j){
        if(i==(arr.length)/2){
            return arr;
        }
        swap(arr, i, j);
        reverseArray(arr, i=i+1, j=j-1);
        return arr;

    }
    static void swap(int [] arr, int start, int end){
        int temp = arr[start];
        arr[start]= arr[end];
        arr[end]= temp;
    }
    static boolean isStringPalindrome(String s, int i){
        if(i==s.length()/2) return true;

        if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        return true;
    }
    static String stringReverse(String s, int i, int j){

        String news = s.replace(s.charAt(i), s.charAt(j));
        stringReverse(news, i=i+1, j=j-1);
        return news;
    }
    static int fibonacciNumber(int n){
        if(n==0 || n==1) return n;
        System.out.println("Value of n : "+ n);
        return fibonacciNumber(n-1)+ fibonacciNumber(n-2);
    }
}
