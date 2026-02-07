package sorting;

import java.util.Arrays;

public class Sorting {
    static void main() {
        int[] arr = {5, 1, 44, 5, 1, 0, -1, 22, 19};
        arr = mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    static void selectionSort(int[] arr) {
        /*
         *  T.C -> 0(N*N)
         *
         * */

        for (int i = 0; i < arr.length; i++) {
            int min = minimum(arr, i, arr.length - 1);
            swap(arr, min, i);
        }

    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int minimum(int[] arr, int i, int j) {
        int min = arr[i];
        int minIndex = i;

        for (int start = i + 1; start <= j; start++) {
            if (arr[start] < min) {
                min = arr[start];
                minIndex = start;
            }
        }
        return minIndex;
    }

    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {

                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    static void insertionSoring(int[] arr) {

        /*
         *  T.C -> 0(N*N)
         *
         * */

        if (arr.length <= 1) return;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];

            int j = i - 1;
            while (j >= 0 && key < arr[j]) {
                swap(arr, j + 1, j);
                if (j != 0) {
                    j--;
                }
            }

        }

    }

    static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    static void recursiveBubbleSort(int[] arr, int i, int j) {
        if (i >= arr.length - 1) return;


        if (j < arr.length - i - 1) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
            recursiveBubbleSort(arr, i, j + 1);
        } else {
            recursiveBubbleSort(arr, i + 1, 0);
        }
    }

    static void recursiveInsertionSort(int[] arr, int i, int j) {
        if (i >= arr.length) return;

        if (j > 0 && arr[j] < arr[j - 1]) {
            swap(arr, j, j - 1);
            recursiveInsertionSort(arr, i, j - 1);
        } else {
            recursiveInsertionSort(arr, i + 1, i + 1);
        }
    }

    static int[] mergeSort(int[] arr, int start, int end) {
        // base case: single element
        if (start == end) {
            return new int[]{arr[start]};
        }

        int mid = start + (end - start) / 2;

        int[] left = mergeSort(arr, start, mid);
        int[] right = mergeSort(arr, mid + 1, end);

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] newArr = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                newArr[k++] = left[i++];
            } else {
                newArr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            newArr[k++] = left[i++];
        }

        while (j < right.length) {
            newArr[k++] = right[j++];
        }

        return newArr;
    }

    static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int partitionIndex = partitionIndex(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);

        }
    }

    static int partitionIndex(int[] arr, int low, int high) {

        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {

            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (arr[j] > pivot && j >= low - 1) {
                j--;
            }
            if (i < j) {
                swap(arr, low, j);
            }

        }

    }
}
