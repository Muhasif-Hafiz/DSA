package sorting;

import java.util.Arrays;

public class Sorting {
    static void main() {
        int[] arr = {4, 3, 2, 1};
        insertionSort(arr);
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
                if (arr[j]<arr[j-1]) {

                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
}
