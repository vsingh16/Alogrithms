package array;

/**
 * Created by vishal on 08-Jul-18.
 * <p>
 * https://www.geeksforgeeks.org/given-matrix-o-x-find-largest-subsquare-surrounded-x/
 * <p>
 * Approach : at each (i,j) we have min hor[i][j] and ver[i][j] whihc returns max possible square length
 * but to confirm we need to check hor[i - (len - 1)][j] >= len && ver[i][j - (len - 1)] >= len
 * <p>
 * if this if false then we will try with len-1
 */
public class LargestSubsquareSurrounded {

    //Time Complexity : O(n^3)
    public static int findMaxSize(char a[][]) {

        int hor[][] = new int[a.length][a[0].length];
        //prepare horizontal matrix
        for (int i = 0; i < a.length; i++) {
            int counter = 0;
            for (int j = 0; j < a[0].length; j++) {
                counter = (a[i][j] == 'X') ? counter + 1 : 0;
                hor[i][j] = counter;
            }
        }

        int ver[][] = new int[a.length][a[0].length];
        //prepare vertical matrix
        for (int j = 0; j < a[0].length; j++) {
            int counter = 0;
            for (int i = 0; i < a.length; i++) {
                counter = (a[i][j] == 'X') ? counter + 1 : 0;
                ver[i][j] = counter;
            }
        }

        //print horizontal
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(hor[i][j]);
            }
            System.out.println();
        }

        System.out.println("=============");
        //print vertical
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(ver[i][j]);
            }
            System.out.println();
        }

        int maxSize = -1;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a[0].length; j++) {
                int len = Math.min(hor[i][j], ver[i][j]);

                while (len > maxSize) {
                    if (hor[i - (len - 1)][j] >= len && ver[i][j - (len - 1)] >= len) {
                        maxSize = len;
                    }
                    len--;
                }
            }

        }


        return maxSize;
    }

    public static void main(String[] args) {
        char mat[][] = {{'X', 'O', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'},
        };

        System.out.println(findMaxSize(mat));
    }
}
