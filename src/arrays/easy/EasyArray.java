package arrays.easy;

public class EasyArray {
    static void main() {
        int[] arr = {1,2,3,4,5,6,6,6,7,7};
        // System.out.println(secondLargestElement(arr));
        System.out.println(removeDuplicates(arr));

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
        while (i < nums.length-1) {
            while ( j<nums.length && nums[j] == nums[i]) {
                j++;
            }
            if(j==nums.length)break;
            i++;
            nums[i] = nums[j];
        }
        return i+1;
    }
}
