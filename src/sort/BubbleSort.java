package sort;

import java.util.Arrays;

/**
 * Created by vishal on 29-Apr-19.
 */
public class BubbleSort {

    /**
     * In bubble sort, we have n-1 no. of passes and each pass, we compare adjacent elements.
     * The largest element goes at the bottom of array in every pass.
     * @param a
     */
    private static void sort(int a[]) {

        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

    }

    /**
     * We can have a swap flag , if array is already sorted the there will be no swap in inner loop,
     * Time complexity in that case becomes O(n) as we will traverse the whole array only once.
     */
    private static void sortOptimized(int a[]) {

        int n = a.length;
        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

    }

    public static void main(String[] args) {

        int a[] = {64, 34, 25, 12, 22, 11, 90};
        sort(a);
        Arrays.stream(a).forEach(System.out::println);

        int a1[] = {1, 2, 3, 4, 5};
        sortOptimized(a1);
        Arrays.stream(a1).forEach(System.out::println);
    }
}
