package arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MediumArray {
    static void main() {

//        int[] arr = {3, 2, 4};
//        System.out.println(Arrays.toString(twoSum(arr, 6)));

        int []arr ={1,2,0,1,2,0,0};
        sortColorsBetter(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] twoSumBrute(int[] nums, int target) {

        int[] ansArr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    ansArr[0] = i;
                    ansArr[1] = j;
                }
            }
        }
        return ansArr;

    }

    public static int[] twoSumBetter(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                return new int[]{i, map.get(rem)};
            } else {
                map.put(nums[i], i);
            }

        }
        return new int[]{-1, -1};

    }

    public static int[] twoSum(int[] nums, int target) {

        int [] originalArr = nums;


        int i = 0;
        int j = nums.length - 1;
        int[] arr = new int[2];


        Arrays.sort(originalArr);
        while (i < originalArr.length && j > 0) {

            long sum = originalArr[i] + originalArr[j];

            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                break;
            }
        }

        for (int k = 0; k < nums.length; k++) {

            if (nums[k] == originalArr[i]) {
                arr[0] = k;
            }
            if (nums[k] == originalArr[j]) {
                arr[1] = k;
            }

        }

        return arr;

        // incomplete

    }
    public static void sortColorsBrute(int[] nums) {

        int count0=0;
        int count1=0;
        int count2 =0;
        int k=0;

        for(int i=0;i<nums.length;i++){

            if(nums[i]== 0) count0++;
            else if(nums[i]==1) count1++;
            else count2++;

        }

        for(int i=0;i<count0;i++){
            nums[k++]=0;
        }
        for(int i=0;i<count1;i++){
            nums[k++]=1;
        }
        for(int i=0;i<count2;i++){
            nums[k++]=2;
        }
    }
//    public static void sortColorsBetter(int[] nums){
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int k=0;
//
//        for(int i=0;i< nums.length;i++){
//            map.put(nums[i],map.getOrDefault(nums[i], 0) +1);
//        }
//        for(Map.Entry<Integer, Integer>  entry : map.entrySet()){
//
//            nums[k++] = entry.getKey();
//        }
//    }

}
