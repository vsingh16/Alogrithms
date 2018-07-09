package array;

/**
 * Created by vishal on 09-Jul-18.
 * <p>
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * <p>
 * If array has all positive numbers , we can simply add them.total sum will be max sum
 * <p>
 * But since array has -ve numbers also, so we will use Kadane Algorithm.
 * i.e max possible sum = 0 (+ve number)
 * <p>
 * so keep on adding elements , if at any point sum_so_far <0 , make it zero
 */
public class LargestSumContinuousSubArray {

    /**
     * Approach: Check for all possible sub array
     * Time Complexity : O(n^2)
     */
    public static int findMaxSum(int a[]) {

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int sum = a[i];
            for (int j = i + 1; j < a.length; j++) {
                sum = sum + a[j];
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }

    //Time Complexity:O(n)
    public static int findMaxSumKadane(int a[]) {

        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (sum < 0) {
                sum = 0;
            }
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    /**
     * Case where all array elements are -ve,
     * SO we cant say if sum<0, sum = 0
     * but we will do sum = Math.max(sum+a[i],a[i])
     *
     */
    public static int findMaxSumWithOnlyNegativeNumbers(int a[]) {

        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            sum = Math.max(a[i], sum + a[i]);
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(findMaxSum(a));
        System.out.println(findMaxSumKadane(a));

        int a1[] = {-2, -3, -4, -1, -2, -1, -5, -3};
        System.out.println(findMaxSumWithOnlyNegativeNumbers(a1));
    }
}
