package arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class ArraysHard {
    static void main() {


//        List<List<Integer>> list = generate(5);
//        System.out.println(list);

        System.out.println(factorial(4,2));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outerList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> innerList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    innerList.add(1);
                } else {
                    if (i > 0) {
                        List<Integer> prev = outerList.get(i - 1);
                        innerList.add(prev.get(j - 1) + prev.get(j));
                    }
                }

            }
            outerList.add(innerList);

        }
        return outerList;
    }

    static int factorial(int n, int r){

        long res = 1;

        for(int i=0;i<r;i++){

            res *= (n-i);
            res /=i+1;
        }
        return (int) res;
    }
}
