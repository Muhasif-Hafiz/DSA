package arrays.medium;

import java.util.*;

public class MediumArray {
    static void main() {

////        int[] arr = {3, 2, 4};
////        System.out.println(Arrays.toString(twoSum(arr, 6)));
//
//        int[] arr = {16, 17, 4, 3, 5, 2};
//
//        //  sortColors(arr);
////        System.out.println(maxProfit(arr));
////        int [] ans = maxSubArrayPart(arr);
////        nextPermutation(arr);
//
//        List<Integer> list = leaders(arr);
//
//
//        System.out.println(list);


       // int[][] ans = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

//        rotate(ans);
//        for (int i = 0; i < ans.length; i++) {
//            for (int j = 0; j < ans[0].length; j++) {
//                System.out.print(ans[i][j] + " ");
//            }
//            System.out.println();
//        }

//        List<Integer> list = spiralOrder(ans);
//        System.out.println(list);


        int [] arr = {1, -1, 1};
     int ans =   subarraySum(arr, 1);
        System.out.println(ans);

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

        int[] originalArr = nums;


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

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) count0++;
            else if (nums[i] == 1) count1++;
            else count2++;

        }

        for (int i = 0; i < count0; i++) {
            nums[k++] = 0;
        }
        for (int i = 0; i < count1; i++) {
            nums[k++] = 1;
        }
        for (int i = 0; i < count2; i++) {
            nums[k++] = 2;
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

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;

            } else if (nums[mid] == 1) {
                mid++;

            } else {
                swap(nums, mid, high);
                high--;

            }
        }

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int majorityElementBrute(int[] nums) {
        int n = nums.length;

        int majority = n / 2;
        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > majority) {
                return nums[i];
            }

        }

        return -1;

    }

    public static int majorityElementBetter(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int majority = nums.length / 2;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majority) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static int maxSubArrayBrute(int[] nums) {
        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;

            for (int j = i; j < nums.length; j++) {

                sum += nums[j];

                maximum = Math.max(sum, maximum);
            }
        }
        return maximum;
    }

    public static int maxSubArray(int[] nums) {

        long sum = 0;
        long maximum = Long.MIN_VALUE;


        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            if (sum > maximum) {
                maximum = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return (int) maximum;
    }

    public static int[] maxSubArrayPart(int[] nums) {

        long sum = 0;
        long maximum = Long.MIN_VALUE;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                start = i;
            }

            sum += nums[i];
            if (sum > maximum) {
                maximum = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return new int[]{ansStart, ansEnd};
    }

    public static int maxProfitBrute(int[] prices) {

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {

                int sellingPrice = prices[j] - prices[i];
                maxProfit = Math.max(sellingPrice, maxProfit);
            }
        }
        return maxProfit;
    }

    public static int maxProfitBetter(int[] prices) {

        //       [ 7, 1, 5, 3, 6, 4 ]

        int minIndex = -1;
        int buyingDay = Integer.MAX_VALUE;
        int maxProfit = 0;


        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < buyingDay) {
                buyingDay = prices[i];
                minIndex = i;
            }
        }

        for (int i = minIndex; i < prices.length; i++) {

            maxProfit = Math.max(maxProfit, prices[i] - prices[minIndex]);

        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }

        }
        return maxProfit;
    }

    public static int[] rearrangeArrayBrute(int[] nums) {

        int[] posArray = new int[nums.length / 2];
        int[] negArray = new int[nums.length / 2];
        int negIndex = 0;
        int posIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negArray[negIndex++] = nums[i];
            } else {
                posArray[posIndex++] = nums[i];
            }
        }

        int newIndex = 0;
        int newNegIndex = 0;
        int newPosIndex = 0;

        while (newIndex < nums.length) {
            nums[newIndex] = posArray[newPosIndex++];
            newIndex++;
            nums[newIndex] = negArray[newNegIndex++];
            newIndex++;
        }
        return nums;
    }

    public static int[] rearrangeArrayTry(int[] nums) {

        int pos = 0;
        int neg = 1;

        while (neg < nums.length && pos < nums.length - 1) {

            if (nums[pos] > 0) {
                if (pos < nums.length - 2) {
                    pos += 2;
                } else {
                    break;
                }
            }
            ;
            if (nums[neg] < 0) {
                if (neg < nums.length - 1) {
                    neg += 2;
                } else {
                    break;
                }
            }


            if (nums[pos] < 0 && nums[neg] > 0) {
                swap(nums, pos, neg);
            }
        }
        return nums;
    }

    public static int[] rearrangeArray(int[] nums) {

        int[] result = new int[nums.length];

        int neg = 1;
        int pos = 0;

        for (int num : nums) {
            if (num > 0) {
                result[pos] = num;
                pos += 2;

            } else {
                result[neg] = num;
                neg += 2;
            }
        }
        return result;

    }

    // [1,2,3] [2,1,3] [3,2,1] [1,3,2]

    static void allPermutations(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                swap(arr, i, j);
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    public static void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            reverse(nums, 0, n);
            return;
        }
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }


        reverse(nums, index + 1, n - 1);

    }

    static void reverse(int[] arr, int low, int high) {

        int mid = low + (high - 1) / 2;

        while (low <= mid && low < high) {
            swap(arr, low, high);
            low++;
            high--;
        }

    }

    public static int longestConsecutiveBetter(int[] nums) {

        // T.C -> 0(NLogN + N)

        int longest = Integer.MIN_VALUE;

        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] - 1) {
                count++;
                longest = Math.max(longest, count);
            } else {
                count = 1;
            }
        }
        return longest;

    }

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        int longest = 0;

        for (int num : nums) {
            set.add(num);
        }


        for (int element : set) {

            if (!set.contains(element - 1)) {

                int currentNum = element;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;

    }

    public static List<Integer> leadersBrute(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            boolean isLeader = true;
            for (int j = i; j < nums.length; j++) {

                if (nums[i] < nums[j]) isLeader = false;
            }
            if (isLeader) list.add(nums[i]);
        }

        return list;
    }

    public static List<Integer> leaders(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int maxRight = nums[n - 1];
        list.add(maxRight);

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > maxRight) {
                maxRight = nums[i];
                list.add(maxRight);
            }

        }

        Collections.reverse(list);
        return list;

    }

    public static void setZeroesBruteForce(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;


        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    alterMatrix(result, i, j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }

    static void alterMatrix(int[][] result, int i, int j) {

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[0].length; col++) {

                if (row == i || col == j) {
                    result[row][col] = 0;
                }
            }
        }

    }

    public static void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }

            }
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;

            }
        }

    }

    public static void rotate(int[][] matrix) {
        transpose(matrix);

        for (int i = 0; i < matrix.length; i++) {
            rotateMatrix(matrix, i);
        }

    }

    public static void transpose(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void rotateMatrix(int[][] matrix, int index) {

        int start = 0;
        int end = matrix.length - 1;

        while (start < end) {
            int temp = matrix[index][start];
            matrix[index][start] = matrix[index][end];
            matrix[index][end] = temp;


            start++;
            end--;

        }

    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);

            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }

    public static int subarraySumForPositivesOnly(int[] nums, int k) {
        if(nums.length==1) {
            if(nums[0]==k) return 1;
            else return 0;
        }


        int i=0;
        int j=1;
        long prefixSum = nums[0];
        int n = nums.length;
        int count =0;

        while(i<n-1 && j<n){
            prefixSum+=nums[j];

            if(prefixSum == k){
                count++;
            }
            while(prefixSum>k){
                prefixSum -=nums[i];
                i++;
                if(prefixSum == k){
                    count++;
                }
            }

            j++;
        }
        return count;

    } public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0,1);

        int prefixSum =0;
        int count =0;



        for(int num : nums){

            prefixSum+= num;


            if(map.containsKey(prefixSum-k)){
                count+=map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return count;

    }


}
