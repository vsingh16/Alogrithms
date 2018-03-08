package dynamic.programming;

/**
 * Created by vishal on 08-Mar-18.
 */
public class Stairs {

    /**
     * Count number of ways to reach Ath stair if u can take either 1 or 2 step
     *
     * count = (n-1)+(n-2) //fabonnaci pattern
     *
     * ways(1) = fib(2) = 1
     ways(2) = fib(3) = 2
     ways(3) = fib(4) = 3
     *
     **
     * We can alos use fabonnaci numbers
     *
     *  {
     if (n <= 1)
     return n;
     return fib(n-1) + fib(n-2);
     }

     * @param A
     * @return
     */
    public static int climbStairs(int A) {

        if (A == 0) {
            return 1;
        }
        if (A == 1) {
            return 1;
        }

        return climbStairs(A - 1) + climbStairs(A - 2);

    }

    /**
     * Number of ways to reach n stairs in m ways
     * ways(n, m) = ways(n-1, m) + ways(n-2, m) + ... ways(n-m, m)
     */
    //Time Complexity:Exponential
    public static int climbStairs(int n, int m) {

        if (n <= 1)
            return n;
        int res = 0;
        for (int i = 1; i <= m && i <= n; i++)
            res += climbStairs(n - i, m);
        return res;
    }

    //Time Complexity:O(mn)
    //Space Complexity:O(n)
    public static int climbStairsDyn(int n, int m) {

        int res[] = new int[n];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n; i++) {
            res[i] = 0;
            for (int j = 1; j <= m && j <= i; j++)
                res[i] += res[i - j];
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(0));
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
    }

}
