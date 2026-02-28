package arrays.hard;

import java.util.*;

public class ArraysHard {
    static void main() {


        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = threeSumBruteForce(arr);
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
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {

                if (nums[i] == nums[j]) count++;
                if (count > nums.length / 3) set.add(nums[i]);

            }
        }

        return new ArrayList<>(set);
    }

    public static List<Integer> majorityElement(int[] nums) {

        int cnt1 = 0;
        int cnt2 = 0;
        int el1 = 0;
        int el2 = 0;

        for (int num : nums) {
            if (cnt1 == 0 && num != el2) {
                el1 = num;
                cnt1++;
            } else if (cnt2 == 0 && num != el1) {
                el2 = num;
                cnt2++;
            } else if (num == el1) cnt1++;
            else if (num == el2) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;

        for (int num : nums) {
            if (num == el1) cnt1++;
            else if (num == el2) cnt2++;
        }

        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        if (cnt1 > n / 3) result.add(el1);
        if (cnt2 > n / 3) result.add(el2);

        return result;

    }

    public static List<List<Integer>> threeSumBruteForce(int[] nums) {

        List<List<Integer>> outerList = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet();

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]== 0){
                        List<Integer> innerList = new ArrayList<>();
                        innerList.add(nums[i]);
                        innerList.add(nums[j]);
                        innerList.add(nums[k]);
                        Collections.sort(innerList);
                        set.add(innerList);
                    }
                }
            }
        }
        outerList.addAll(set);
        return outerList;

    }
}
