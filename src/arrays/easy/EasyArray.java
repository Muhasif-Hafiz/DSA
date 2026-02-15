package arrays.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class EasyArray {
    static void main() {
//        int[] arr = {0,0,0,1,0,0,2,0,0,4,0};
//        // System.out.println(secondLargestElement(arr));
//        moveZeroesOptimal(arr);
//        System.out.println(Arrays.toString(arr));
////
//        int[] nums1 = {3, 4, 6, 7, 9, 9};
//        int[] nums2 = {1, 5, 7, 8, 8};
//        int [] ans = unionArray(nums1, nums2);
//        System.out.println(Arrays.toString(ans));
        // int [] ans=  unionArrayOptimal(nums1, nums2);

        int[] arr = {2,0,0,3};
        System.out.println(longestSubarray(arr, 2));

    }

    static int secondLargestElement(int[] arr) {
        /*
         * Brute Force -> Sort the Array, And then pick up the second largest element
         * T.C -> 0(NLOGN)
         *
         * But we will do something more better, This approach is 0(N)  T.C
         * */

        if (arr.length == 1) return arr[0];
        int max = Integer.MIN_VALUE;
        int maxIndex = Integer.MAX_VALUE;
        int secondMaxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMaxIndex = maxIndex;
                max = arr[i];
                maxIndex = i;
            }

        }
        return arr[secondMaxIndex];
    }

    static boolean isSorted(int[] nums, int low, int high, int pivotIndex) {
        boolean isSorted = false;

        for (int i = low; i < high; i++) {
            if (nums[i] < nums[i + 1] && nums[pivotIndex] > nums[i]) {
                isSorted = true;
            } else {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }

    static public boolean check(int[] nums) {
        if (nums.length <= 1) return true;

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
            }
        }
        if (count == 0) return true; // fully sorted

        if (count == 1 && nums[nums.length - 1] <= nums[0]) {
            return true;
        }

        return false;

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int i = 0;
        int j = i + 1;
        while (i < nums.length - 1) {
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (j == nums.length) break;
            i++;
            nums[i] = nums[j];
        }
        return i + 1;
    }

    static void reverse(int[] arr, int low, int high) {

        int mid = low + (high - 1) / 2;

        while (low <= mid && low < high) {
            swap(arr, low, high);
            low++;
            high--;
        }

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    static int[] rotateBrute(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];

        k = k % n;
        int j = 0;

        for (int i = n - k; i < n; i++) {
            newArr[j++] = nums[i];
        }

        for (int i = 0; i < n - k; i++) {
            newArr[j++] = nums[i];
        }

        return newArr;
    }

    public static void moveZeroes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        for (int i = list.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeroesOptimal(int[] nums) {
        int i = 0;
        int j = 0;

        while (i < nums.length) {
            while (nums[j] == 0) {
                if (j < nums.length - 1) {
                    j++;
                } else {
                    break;
                }
            }
            swap(nums, i, j);
            i++;
            if (nums[j] != 0) j++;
        }
    }

    public static int[] unionArray(int[] nums1, int[] nums2) {


        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }
        int[] result = new int[set.size()];
        int i = 0;

        for (int num : set) {
            result[i++] = num;
        }
        return result;
    }

    public static int[] unionArrayOptimal(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int prev = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                if (prev != nums1[i]) {
                    list.add(nums1[i]);
                    prev = nums1[i];
                }
                i++;
            } else {
                if (prev != nums2[j]) {
                    list.add(nums2[j]);
                    prev = nums2[j];
                }
                j++;
            }

        }

        while (i < nums1.length) {
            if (prev != nums1[i]) {
                list.add(nums1[i]);
                prev = nums1[i];
            }
            i++;
        }
        while (j < nums2.length) {
            if (prev != nums2[j]) {
                list.add(nums2[j]);
                prev = nums2[j];
            }
            j++;
        }
        int[] newArr = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            newArr[k] = list.get(k);
        }

        return newArr;
    }

    static int findMissingNumberBetter(int[] arr) {
        boolean[] hashArray = new boolean[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 1;
            hashArray[index] = true;
        }
        int ans = 0;
        for (int i = 1; i < hashArray.length; i++) {
            if (!hashArray[i]) {
                ans = i;
            }
        }

        return ans + 1;
    }

    static int findMissingNumber(int[] arr) {

        long n = arr.length + 1;
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        long expectedSum = n * (n + 1) / 2;


        return (int) (expectedSum - sum);

    }

//    public static int findMaxConsecutiveOnes(int[] nums) {
//
//        int count = 0;
//        int max = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if   (nums[i] == 0) count = 0;
//            else count++;
//            if (max < count) {
//                max = count;
//            }
//        }
//        return max;
//    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {

            if (num == 1) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 0;
            }

        }
        return max;
    }
    public static int singleNumberBruteFoce(int[] nums) {

        int cnt =0;
        for(int i=0;i<nums.length;i++){

            for(int j=0;j<nums.length;j++){
                if(nums[i]== nums[j]) cnt++;

                if(cnt>=2){
                    cnt=0;
                    break;
                }

            }
            if(cnt==1) return nums[i];
        }


        return cnt;
    }
    static  int singleNumber(int [] nums){

        int sum =0;

        for(int i=0;i<nums.length;i++){
            sum = sum ^nums[i];
        }
        return sum;
    }
    public static int longestSubarrayBrute(int[] nums, int k) {

        int maxLen =0;
        for(int i=0;i<nums.length;i++){
            int sum =0;
            for(int j=i;j<nums.length;j++){
                sum +=nums[j];

                if(sum == k){
                    maxLen = Math.max(maxLen, (j-i+1));
                    break;
                }
            }
        }
        return maxLen;
    }
    public static int longestSubarray(int[] nums, int k) {


       int i=0; int j=0;
       int maxLen=0;
        long  sum =nums[i];

       while(j< nums.length){

           while(i<=j && sum>k){
               sum -=nums[i];
               i++;
           }

           if(sum ==k){
               maxLen = Math.max(maxLen, j-i+1);
           }
           j++;
           if(j<nums.length) sum +=nums[j];

       }
       return maxLen;
    }
    public static int longestSubarrayBetter(int[] nums, int k) {

        int maxLen = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if(sum == k) {
                maxLen = i + 1;
            }

            int rem = sum - k;

            if(map.containsKey(rem)) {
                maxLen = Math.max(maxLen, i - map.get(rem));
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    //
}
