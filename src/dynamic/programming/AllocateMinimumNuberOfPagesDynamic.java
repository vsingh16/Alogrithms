package dynamic.programming;

/**
 * Created by vishal on 24-Mar-18.
 * <p>
 * Allocate minimum number of pages
 * Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages. Every student is assigned to read some consecutive books.
 * The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.
 * <p>
 * Input : pages[] = {12, 34, 67, 90}
 * m = 2
 * Output : 113
 * Explanation:
 * There are 2 number of students. Books can be distributed
 * in following fashion :
 * 1) [12] and [34, 67, 90]
 * Max number of pages is allocated to student
 * 2 with 34 + 67 + 90 = 191 pages
 * 2) [12, 34] and [67, 90]
 * Max number of pages is allocated to student
 * 2 with 67 + 90 = 157 pages
 * 3) [12, 34, 67] and [90]
 * Max number of pages is allocated to student
 * 1 with 12 + 34 + 67 = 113 pages
 * <p>
 * Of the 3 cases, Option 3 has the minimum pages = 113.
 */
public class AllocateMinimumNuberOfPagesDynamic {

    /**
     * Time Complexity:O(n^3)
     * Space Complexity:O(books*totalStudents)
     *
     * @param books
     * @param totalStudents
     */
    public static int findMinPagesDynaimc(int books[], int totalStudents) {

        int n = books.length;

        //if number of books are less than total student , they can't be distributed
        if (n < totalStudents) {
            return -1;
        }
        int dp[][] = new int[n][totalStudents];

        //when there is only one student
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += books[i];
            dp[i][0] = sum;
        }

        for (int j = 1; j < totalStudents; j++) {
            for (int i = 0; i < n; i++) {
                sum = 0;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k > 0; k--) {
                    sum += books[k];
                    dp[i][j] = Math.min(dp[i][j], Math.max(sum, dp[k - 1][j - 1]));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < totalStudents; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();

        }

        return dp[n - 1][totalStudents - 1];
    }

    private static Boolean checkForFeasibility(int books[], int totalStudents, int minAllocatedValue) {

        int sum = 0, studentCount = 1;
        for (int i = 0; i < books.length; i++) {

            /**
             * if single book page is greater than minAllocatedValue, this case is not feasible
             * and our value min value should >=single book page
             */
            if (books[i] > minAllocatedValue) {
                return false;
            }

            /**
             * if total page exceeds min value then we need to assign from that book onwards to different student
             * and if total studnet exceeds given student count, soultion is not feasible
             */
            if (sum + books[i] > minAllocatedValue) {
                studentCount++;
                if (studentCount > totalStudents) {
                    return false;
                }
                sum = books[i];
            } else {
                sum += books[i];
            }
        }

        return true;
    }


    /**
     * Since books are ordered in ascending order, we can use binary search to get the results.
     * <p>
     * Time Complexity:O(n^2)
     * <p>
     * Space Complexity:O(n^3)
     *
     * @return
     */
    public static int findMinPagesBinarySearch(int books[], int totalStudents) {

        int n = books.length;

        //if number of books are less than total student , they can't be distributed
        if (n < totalStudents) {
            return 0;
        }

        int l = books[0];
        int h = 0;
        for (int i = 0; i < n; i++) {
            h += books[i];
        }

        int mid = 0;
        int result = Integer.MAX_VALUE;
        while (l <= h) {
            mid = (l + h) / 2;
            boolean isFeasible = checkForFeasibility(books, totalStudents, mid);
            if (isFeasible) {
                result = Math.min(result, mid);
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int books[] = {12, 34, 67, 90};
        System.out.println("result " + findMinPagesDynaimc(books, 2));
        System.out.println("result " + findMinPagesDynaimc(books, 3));
        System.out.println("result " + findMinPagesBinarySearch(books, 2));
        System.out.println("result " + findMinPagesBinarySearch(books, 3));

    }
}
