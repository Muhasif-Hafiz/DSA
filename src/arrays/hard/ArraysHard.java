package arrays.hard;

import java.util.*;

public class ArraysHard {
    static void main() {


        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
//        List<List<Integer>> list = fourSum(arr, 0);
//        System.out.println(list);

        // System.out.println(factorial(4,2));
        System.out.println(maxLenBetter(arr));
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

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
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

    public static List<List<Integer>> threeSumBetter(int[] nums) {
        /*
         *  T.C -> 0(N^2)
         *  S.C -> 0(N^2)
         *
         *
         * */


        List<List<Integer>> outerList = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet();


        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {

                int number = nums[i] + nums[j];
                if (map.containsKey(number * -1)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(number * -1);
                    list.add(nums[j]);
                    Collections.sort(list);
                    set.add(list);
                } else {
                    map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                }
            }
        }
        outerList.addAll(set);
        return outerList;

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outerList = new ArrayList<>();
        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    outerList.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return outerList;

    }

    public static List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int k = j + 1;
                int l = arr.length - 1;
                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum == target) {
                        ans.add(List.of(arr[i], arr[j], arr[k], arr[l]));

                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                    while (k < l && arr[k] == arr[k + 1]) k++;
                    while (k < l && arr[l] == arr[l - 1]) l--;
                }


            }
        }
        return ans;
    }
    public static int maxLenBrute(int[] arr) {

        int  count = 0;

        for (int i = 0; i < arr.length; i++) {
            long sum =0;
            for (int j = i; j <arr.length ; j++) {

                sum+=arr[j];
                if(sum ==0){
                    int minLength = j-i+1;
                    count = Math.max(minLength, count);
                }
            }
        }
        return count;
    }
    public static int maxLenBetter(int[] arr) {
        HashMap<Integer, Integer> map =  new HashMap<>();
        int count =0;
        int maxSum =0;

        map.put(0,0);

        for(int i=0;i<arr.length;i++){
            maxSum +=arr[i];

            if(map.containsKey(maxSum)){
                int len =  (i+1)-map.get(maxSum);
                count = Math.max(count, len);
            }else{
                map.put(maxSum, i+1);
            }
        }
        return count;
    }
}
