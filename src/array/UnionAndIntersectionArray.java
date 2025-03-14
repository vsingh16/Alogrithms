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
Compare elements:
If both elements are equal, print one and move both pointers.
If one element is smaller, print it and move that pointer.
If one array is exhausted, print remaining elements from the other.
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
=========================================================================
WAP to print intersection of two arrays

Approach 1: Using HashSet (Efficient)
Store elements of the first array in a HashSet.
Traverse the second array and check if elements exist in the HashSet.
If an element is found in the set, print it and remove it to avoid duplicates.
Time Complexity:
O(m + n) → HashSet operations are O(1) on average.
Space Complexity:
O(min(m, n)) → To store intersection elements.

import java.util.HashSet;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4, 5};
        int[] arr2 = {2, 2, 3, 5, 6};

        printIntersection(arr1, arr2);
    }

    public static void printIntersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        // Store elements of arr1 in HashSet
        for (int num : arr1) {
            set.add(num);
        }

        // Check for intersection in arr2
        for (int num : arr2) {
            if (set.contains(num)) {
                intersection.add(num);
            }
        }

        // Print intersection
        System.out.println("Intersection of two arrays: " + intersection);
    }
}

Approach 2: Using Two-Pointer Technique (Without Extra Space)
Sort both arrays (if not already sorted).
Use two-pointer technique to find the intersection efficiently.
Skip duplicates to avoid repetition.
Time Complexity:
O(m log m + n log n) → Sorting both arrays.
O(m + n) → Two-pointer traversal.
Overall: O(m log m + n log n).
Space Complexity:
O(1) → No extra space used.
    
import java.util.Arrays;

public class IntersectionWithoutExtraSpace {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4, 5};
        int[] arr2 = {2, 2, 3, 5, 6};

        printIntersection(arr1, arr2);
    }

    public static void printIntersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1); // Sort both arrays
        Arrays.sort(arr2);

        int i = 0, j = 0;
        System.out.print("Intersection of two arrays: ");

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else { // Common element found
                System.out.print(arr1[i] + " ");
                i++;
                j++;

                // Skip duplicates in both arrays
                while (i < arr1.length && arr1[i] == arr1[i - 1]) i++;
                while (j < arr2.length && arr2[j] == arr2[j - 1]) j++;
            }
        }
        System.out.println();
    }
}
    
    
