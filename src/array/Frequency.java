package com.vishal.hackerrank;

/**
 * Created by vishal on 27-Dec-20.
 * <p>
 * Find frequency of elements in an array of length n in O(n) time and O(1) space.
 * <p>
 * Method, we can maintain a count array but since it is mentioned we can't maintain extra array
 * <p>
 * Step 1: reduce all elements by one , so that they can fall in range 0 to n-1 index
 * Step 2: Traverse array. go to a[i] and incerease it by n .
 * Step 3: if(a[i]<n) {a[a[i]] += n}
 * Step 4: else a [ a[i] % n] += n;
 * Step 5:  result : element = i+1 and feq. = a[i]/n;
 */
public class Frequency {

    public static void print(int a[]) {

        int n = a.length;
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] - 1;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] > n) {
                a[a[i] % n] = a[a[i] % n] + n;
            } else {
                a[a[i]] = a[a[i]] + n;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Element: " + (i + 1) + " Frequency: " + a[i] / n);
        }

    }

    public static void main(String[] args) {
        int a1[] = {2, 3, 3, 2, 5};
        print(a1);
        System.out.println("==================");
        int a2[] = {4, 4, 4, 4};
        print(a2);
    }

}
