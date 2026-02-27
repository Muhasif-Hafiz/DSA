package arrays.hard;

import java.util.*;

public class ArraysHard {
    static void main() {


        int[] arr = {1, 2, 1, 1, 3, 2, 2};
        List<Integer> list = majorityElementBruteForce(arr);
        System.out.println(list);

        // System.out.println(factorial(4,2));
    }

    public static List<List<Integer>> generatePascalBrute(int numRows) {
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

    static int factorial(int n, int r) {

        long res = 1;

        for (int i = 0; i < r; i++) {

            res *= (n - i);
            res /= i + 1;
        }
        return (int) res;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outerList = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> inner = new ArrayList<>();

            inner = generateRow(i);

            outerList.add(inner);
        }
        return outerList;

    }

    public static List<Integer> generateRow(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int res = 1;

        for (int i = 1; i < n; i++) {

            res = res * (n - i);
            res = res / i;

            list.add(res);
        }
        return list;
    }

    public static List<Integer> majorityElementBruteForce(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> map = new HashSet<>();
        int threshold = nums.length / 3;

        for (int i = 0; i < nums.length; i++) {

            int count = 0;
            for (int j = i; j < nums.length; j++) {

                if (nums[i] == nums[j]) count++;

                if (count > threshold) {
                    map.add(nums[i]);
                }
            }
        }
        for(int num : map){
            list.add(num);
        }
        return list;

    }
}
