package array;

/**
 * Created by vishal on 03-Jul-18.
 *
 * https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * 
 */
public class PrintSprialMatrix {

    public static void print(int a[][]) {

        int rows = a.length, cols = a[0].length;
        int l = 0, r = cols - 1, u = 0, d = rows - 1;

        while (l <= r && u <= d) {

            //print left to right
            for (int i = l; i <= r; i++) {
                System.out.print(a[l][i] + " ");
            }

            //print up to down
            for (int i = u + 1; i <= d; i++) {
                System.out.print(a[i][r] + " ");
            }

            //print right to left
            for (int i = r - 1; i >= l; i--) {
                System.out.print(a[d][i] + " ");
            }

            //print down to up
            for (int i = d - 1; i > l; i--) {
                System.out.print(a[i][l] + " ");
            }


            l++;
            r--;
            u++;
            d--;
            System.out.println();
        }


    }

    public static void main(String[] args) {

        int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        print(a);

        int a1[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        print(a1);
    }

}
