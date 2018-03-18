package dynamic.programming;

/**
 * Created by vishal on 18-Mar-18.
 */
public class LargestSumSubArray {

    /**
     * Simply iterate over all array elements one by one, and calculate the sum
     * Time Complexity:O(n*n)
     */
    public static int maxSumSubArrayNaive(int a[]) {

        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }


    /**
     * Kadane's Algorithm
     * Iterate over elements and do their sum, if sum is -ve at any point we will be ignoring that segment
     * and start with new segment
     * But this not handle the case when all elements is array are -ve
     * Time Complexity:O(n)
     */
    public static int maxSumSubArrayKadane(int a[]) {

        int sum = 0, maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum < 0) {
                sum = 0;//i.e if any segment sum is -ve, we will ignore that segment
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    /**
     * THis method handles the case when all elements are -ve.
     * At every element, either we start a new segment or include curret element in existing segment
     * Time Complexity:O(n)
     *
     *
     */
    public static int maxSumSubArrayAllNegative(int a[]) {

        int curSum = 0, maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            curSum = Math.max(a[i], curSum + a[i]);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }


    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSumSubArrayNaive(a));//7
        System.out.println(maxSumSubArrayKadane(a));//7
        System.out.println(maxSumSubArrayAllNegative(a));//7
    }
}
