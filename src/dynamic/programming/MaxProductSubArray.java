package dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vishal on 20-Mar-18.
 * Maximum Product Subarray
 * Given an array that contains both positive and negative integers, find the product of the maximum product subarray.
 */
public class MaxProductSubArray {

    /**
     * Method 1:Naive Approach, Simply check for all possible combinations
     * <p>
     * Time Complexity:O(n^2)
     * Space Complexity:O(1)
     */
    public static int maxSubarrayProductNaive(int a[]) {

        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int product = a[i];
            for (int j = i + 1; j < a.length; j++) {
                product = product * a[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }

    /**
     * Method 2:
     * Iterate over array
     * Since this is multiplication, we also need to consider -ve values as -2*-3=6 i.e two -ve numbers prod will be +ve
     * if a[i] = +ve, max = max*a[i] but for min we need to compare with prev min
     * if a[i] = -ve,max = a[i]*min and compare with prev max
     * also min = a[i]*max and compare with current element
     * Compare maxSOFar with maxResult to return max result.
     * <p>
     * Time Complexity:O(n)
     * Space Complexity:O(1)
     */
    public static int maxProduct(final List<Integer> a) {

        if (a.size() == 0) {
            return 0;
        }
        int minSoFar = a.get(0);
        int maxSoFar = a.get(0);
        int maxResult = a.get(0);
        for (int i = 1; i < a.size(); i++) {

            if (a.get(i) > 0) {
                maxSoFar = maxSoFar * a.get(i);
                minSoFar = Math.min(minSoFar * a.get(i), minSoFar);
            }/**
             if element is zero, we wll skip this and start from next element
             **/
            else if (a.get(i) == 0) {
                minSoFar = i + 1 < a.size() ? a.get(i + 1) : 0;
                maxSoFar = i + 1 < a.size() ? a.get(i + 1) : 0;
                i++;
            } else {
                int temp = maxSoFar;
                maxSoFar = Math.max(minSoFar * a.get(i), a.get(i));
                minSoFar = temp * a.get(i);
            }

            maxResult = Math.max(maxResult, maxSoFar);

        }

        return maxResult;
    }

    public static void main(String[] args) {
        /*int a[] = {6, -3, -10, 0, 2};
        System.out.println(maxSubarrayProductNaive(a));//180
        System.out.println(maxSubarrayProduct(a));//180

        int arr[] = {1, -2, -3, 0, 7, -8, -2};
        System.out.println(maxSubarrayProduct(arr));//112
        System.out.println(maxSubarrayProduct(arr));//112

        int a1[] = {-1, -3, -10, 0, 60};
        System.out.println(maxSubarrayProduct(a1));//60
        System.out.println(maxSubarrayProduct(a1));//60

        int a2[] = {-2, -3, 0, -2, -40};
        System.out.println(maxSubarrayProduct(a2));//80
        System.out.println(maxSubarrayProduct(a2));//80

        int a3[] = {0, 0, -20, 0};
        System.out.println(maxSubarrayProduct(a3));//0

        int a4[] = {0, 0, 0, 0};
        System.out.println(maxSubarrayProduct(a4));//0*/

        System.out.println(maxProduct(new ArrayList<>(Arrays.asList(2, 3, -2, 4))));
        System.out.println(maxProduct(new ArrayList<>(Arrays.asList(1, -2, -3, 0, 7, -8, -2))));
        System.out.println(maxProduct(new ArrayList<>(Arrays.asList(6, -3, -10, 0, 2))));
        System.out.println(maxProduct(new ArrayList<>(Arrays.asList(-1, -3, -10, 0, 60))));
        System.out.println(maxProduct(new ArrayList<>(Arrays.asList(-2, -3, 0, -2, -40))));
        System.out.println(maxProduct(new ArrayList<>(Arrays.asList(0, 0, 0, 0))));

    }
}

