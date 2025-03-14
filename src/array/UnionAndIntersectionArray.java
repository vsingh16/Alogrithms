package array;

import java.util.Arrays;

/**
** Approach:
** Use a HashSet to store unique elements.
** Add all elements from the first array to the set.
** Add all elements from the second array to the set.
** Print the set, which contains the union of both arrays.
** Time Complexity: O(m + n) → where m and n are the sizes of the two arrays.
** Space Complexity: O(m + n) → To store the unique elements in the HashSet
 */
import java.util.HashSet;

public class UnionOfArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7, 8};

        printUnion(arr1, arr2);
    }

    public static void printUnion(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        // Add elements of arr1
        for (int num : arr1) {
            set.add(num);
        }

        // Add elements of arr2
        for (int num : arr2) {
            set.add(num);
        }

        // Print union of arrays
        System.out.println("Union of two arrays: " + set);
    }
}
=======================================================================
Approach (Handling Unsorted Arrays Without Extra Space)
Sort both arrays using an efficient sorting algorithm (e.g., Arrays.sort() in Java, which uses Timsort with O(n log n) complexity).
Use two-pointer technique to find and print the union of the arrays efficiently.
Skip duplicates while processing.
Time Complexity:
O(m log m + n log n) → Sorting both arrays.
O(m + n) → Merging with two-pointer traversal.
Overall: O(m log m + n log n).
Space Complexity:
O(1) → No extra space used    

import java.util.Arrays;

public class UnionUnsortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {5, 3, 1, 2, 4};
        int[] arr2 = {8, 7, 6, 3, 4, 5};

        printUnion(arr1, arr2);
    }

    public static void printUnion(int[] arr1, int[] arr2) {
        // Sort both arrays first
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int m = arr1.length, n = arr2.length;
        int i = 0, j = 0;

        System.out.print("Union of two arrays: ");

        while (i < m && j < n) {
            // Skip duplicates in arr1
            while (i > 0 && i < m && arr1[i] == arr1[i - 1]) i++;
            // Skip duplicates in arr2
            while (j > 0 && j < n && arr2[j] == arr2[j - 1]) j++;

            if (i < m && j < n) {
                if (arr1[i] < arr2[j]) {
                    System.out.print(arr1[i++] + " ");
                } else if (arr1[i] > arr2[j]) {
                    System.out.print(arr2[j++] + " ");
                } else { // Equal elements
                    System.out.print(arr1[i++] + " ");
                    j++;
                }
            }
        }

        // Print remaining elements of arr1
        while (i < m) {
            if (i == 0 || arr1[i] != arr1[i - 1]) 
                System.out.print(arr1[i] + " ");
            i++;
        }

        // Print remaining elements of arr2
        while (j < n) {
            if (j == 0 || arr2[j] != arr2[j - 1]) 
                System.out.print(arr2[j] + " ");
            j++;
        }

        System.out.println();
    }
}
    

    
