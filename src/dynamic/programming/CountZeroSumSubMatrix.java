package dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vishal on 18-Mar-18.
 * <p>
 * Given a 2D matrix, find the number non-empty sub matrices, such that the sum of the elements inside the sub matrix is equal to 0. (note: elements might be negative).
 * <p>
 * eg input:
 * -8 5  7
 * 3  7 -8
 * 5 -8  9
 * <p>
 * output:
 * count = 2
 * 1){-8
 * 3
 * 5}
 * <p>
 * 2) {7, -8,
 * -8, 9}
 * <p>
 * Method 1:Use four loops for all possible sub matrix combination and check for zero
 * sum : Time Complecity O(n^4)
 * <p>
 * Method 2:Take two pointers left and right,Do row wise sum in between to form 1 D Array, then apply
 * algorithm to count zero sub array on it.
 * Time Complexity :O(n^3)
 */
public class CountZeroSumSubMatrix {

    public static int countZeroSumSubArrayHashing(int a[]) {

        int sum = 0, maxLen = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {

            sum = sum + a[i];
            //if any element itself is zero,maxlen =1
            if (a[i] == 0) {
                count++;
            } else if (sum == 0) {
                count++;
            } else {
                Integer previousIndex = map.get(sum);
                if (previousIndex != null) {
                    maxLen = Math.max(maxLen, i - previousIndex);
                    count++;
                } else {
                    map.put(sum, i);
                }
            }
        }

        return count;
    }

    public static int solve(ArrayList<ArrayList<Integer>> A) {

        int r = A.size();
        int c = A.get(0).size();
        int count = 0;
        for (int left = 0; left < c; left++) {
            int temp[] = new int[r];
            for (int right = left; right < c; right++) {
                for (int k = 0; k < r; k++) {
                    temp[k] += A.get(k).get(right);
                }
                count += countZeroSumSubArrayHashing(temp);
            }
        }

        return count;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(-8, 5, 7)));
        input.add(new ArrayList<>(Arrays.asList(3, 7, -8)));
        input.add(new ArrayList<>(Arrays.asList(5, -8, 9)));
        System.out.println(solve(input));

    }

}

