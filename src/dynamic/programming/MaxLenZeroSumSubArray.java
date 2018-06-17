package dynamic.programming;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vishal on 18-Mar-18.
 * <p>
 * Find the largest subarray with 0 sum
 * Given an array of integers, find length of the largest subarray with sum equals to 0.
 * <p>
 * Method 1:Iterate all array elements one by one, and do sum
 * <p>
 * Method 2:Iterate all array elements starting from zero and put it in hashmap.
 * If same sum comes again, this means array elements from previous index to i add up to zero.
 * eg {15,2,-2}
 * map.put(15,0)
 * 15+2-2 = 15 i.e 2,-2 are zero
 */
public class MaxLenZeroSumSubArray {

    /**
     * Time Complexity:O(n*n)
     * Space Complexity:O(1)
     */
    public static int maxLen(int a[]) {

        int maxLen = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum = sum + a[j];

                if (sum == 0) {
                    maxLen = Math.max(maxLen, (j - i) + 1);
                }
            }
        }
        return maxLen;
    }

    /**
     * Time Complexity:O(n)
     * Time Complexity of this solution can be considered as O(n) under the assumption that we have
     * good hashing function that allows insertion and retrieval operations in O(1) time.
     * Space Complexity:O(n)
     */
    public static int maxLenHashing(int a[]) {

        int sum = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {

            //if any element itself is zero,maxlen =1
            if (a[i] == 0) {
                maxLen = Math.max(maxLen, 1);
            }

            sum = sum + a[i];
            if (sum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }
            Integer previousIndex = map.get(sum);
            if (previousIndex != null) {
                maxLen = Math.max(maxLen, i - previousIndex);
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr));

        int arr1[] = {15, -2, 2, -8, 1, 7, 10, 23, 0};
        System.out.println(maxLen(arr1));

        int arr2[] = {0, 2, -2};
        System.out.println(maxLen(arr2));

        int arr3[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLenHashing(arr3));

        int arr4[] = {15, -2, 2, -8, 1, 7, 10, 23, 0};
        System.out.println(maxLenHashing(arr4));

        int arr5[] = {0, 2, -2};
        System.out.println(maxLenHashing(arr5));
    }
}
