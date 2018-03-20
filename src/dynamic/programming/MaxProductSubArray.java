package dynamic.programming;

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
     * At each, ith index,we will calculate two products, one wil max so far and other with min so far
     * Compare maxSOFar with maxResult to return max result.
     * <p>
     * Time Complexity:O(n)
     * Space Complexity:O(1)
     */
    public static int maxSubarrayProduct(int a[]) {

        int minSoFar = a[0];
        int maxSoFar = a[0];
        int maxResult = a[0];
        for (int i = 1; i < a.length; i++) {

            if (a[i] == 0) {
                minSoFar = i + 1 < a.length ? a[i + 1] : 0;
                maxSoFar = i + 1 < a.length ? a[i + 1] : 0;
                i++;
            } else {
                int prod1 = minSoFar * a[i];
                int prod2 = maxSoFar * a[i];
                minSoFar = Math.min(Math.min(prod1, prod2), minSoFar);
                maxSoFar = Math.max(Math.max(prod1, prod2), maxSoFar);
            }

            maxResult = Math.max(maxResult, maxSoFar);

        }

        return maxResult;
    }

    public static void main(String[] args) {
        int a[] = {6, -3, -10, 0, 2};
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
        System.out.println(maxSubarrayProduct(a4));//0

    }
}

