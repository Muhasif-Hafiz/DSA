package maths;

import java.util.ArrayList;

public class SieveOfEratosthenes {
    static void  main(String[] args){
        System.out.println(primeNumbers(30));

    }
    static ArrayList<Integer> primeNumbers(int num){
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] sieve = new boolean[num + 1];

        for(int i = 2; i <= num; i++){
            if(!sieve[i]){
                list.add(i);
                for(int j = i * i; j <= num; j += i){
                    sieve[j] = true;
                }
            }
        }
        return list;
    }

}
