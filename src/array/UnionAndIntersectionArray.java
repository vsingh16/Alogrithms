package array;

import java.util.Arrays;

/**
 * Created by vishal on 23-May-18.
 * <p>
 * Print union and intersetion of array elements.
 * One Approach could be with two inner loops.
 * Time Complexity : o(m*n)
 * <p>
 * Second Approach:With Sorting
 * Time Complexity:O(nlogn)
 */
public class UnionAndIntersectionArray {

    public static void main(String[] args) {

        int a[] = {4, 7, 3, 9, 2};
        int b[] = {3, 2, 12, 9, 40, 32};

        //printUnion(a, b);
        System.out.println("Printing Common elements");
        printIntersection(a, b);
    }

    private static void printUnion(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        int l = 0, h = 0;
        int c[] = new int[a.length + b.length];
        int pos = 0;
        while (l < a.length && h < b.length) {
            if (a[l] < b[h]) {
                c[pos++] = a[l++];
            } else {
                c[pos++] = b[h++];
            }
        }

        while (l < a.length) {
            c[pos++] = a[l++];
        }

        while (h < b.length) {
            c[pos++] = b[h++];
        }

        Arrays.stream(c).forEach(System.out::println);
    }

    private static void printIntersection(int a[], int b[]) {

        Arrays.sort(a);
        Arrays.sort(b);
        int l = 0, h = 0;
        while (l < a.length && h < b.length) {

            if (a[l] < b[h]) {
                l++;
            } else if (b[h] < a[l]) {
                h++;
            } else {
                System.out.println(a[l]);
                l++;
                h++;
            }
        }

    }
}
