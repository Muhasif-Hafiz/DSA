package hashing;

import java.util.*;

public class Hashing {
    static void main(String[] args) {

        int[] arr = {1,1};
//        System.out.println(countFrequenciesBrute(arr));

        int [] ans = countFrequencyOptimized(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static List<List<Integer>> countFrequencies(int[] nums) {
        List outerList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            outerList.add(List.of(entry.getKey(), entry.getValue()));
        }

        return outerList;
    }

    static List<List<Integer>> countFrequenciesBrute(int[] nums) {
        /* T.C  0(N^2)

         * S.C  0(N)
         * Brute Force Solution
         *
         * */
        List<List<Integer>> list = new ArrayList<>();
        boolean[] trace = new boolean[nums.length];  // S.C -> 0(N)

        for (int i = 0; i < nums.length; i++) { // T.C -> 0(N)
            List<Integer> innerList = new ArrayList<>();
            if (!trace[i]) {
                innerList.add(nums[i]);
                int count = 0;
                for (int j = i; j < nums.length; j++) {  // T.C -> 0(N)
                    if (nums[i] == nums[j]) {
                        count++;
                        trace[j] = true;
                    }
                }
                innerList.add(count);
                list.add(innerList);
            }

        }
        return list;
    }

    static int[] countFreq(int[] nums) {
        /*
        * BRUTE FORCE
        *  T.C  0(N^2)
        *
        *  S.C  0(N)
        *
        * */

        boolean[] trace = new boolean[nums.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minValue = 0;
        int maxValue =0;

        for(int i=0;i<nums.length;i++){
            int count =0;
            if(!trace[i]){
                for (int j =i;j<nums.length;j++){
                    if(nums[i]== nums[j]){
                        count++;
                        trace[j] = true;
                    }
                }
                if(count>max){
                    max = count;
                    maxValue =nums[i];

                }
                if(count<min){
                    min= count;
                    minValue = nums[i];
                }
            }
        }

        return new int[] {maxValue, minValue};
    }
    static  int [] countFrequencyOptimized(int [] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minValue = 0;
        int maxValue =0;

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1 );
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
                maxValue = entry.getKey();
            }
            if(entry.getValue()<min){
                min = entry.getValue();
                minValue = entry.getKey();
            }
        }

            return new int[] {maxValue, minValue};

    }
}
