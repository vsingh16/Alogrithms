package array;

/**
 * Given an array A[], write a function that segregates even and odd numbers. The functions should put all even numbers first, and then odd numbers.
 * <p>
 * Input  = {12, 34, 45, 9, 8, 90, 3}
 * Output = {12, 34, 8, 90, 45, 9, 3}
 *
 * Time Complexity: O(n)
 *
 * Created by vishal on 17-Jun-18.
 */
public class SegregrateOddEven {

    public static void segregateEvenOdd(int arr[]) {

        int l = 0, r = arr.length - 1;
        while (l < r) {

            while (arr[l] % 2 == 0) {
                l++;
            }

            while (arr[r] % 2 != 0) {
                r--;
            }

            if (l < r) {
                //swap arr[l] and arr[r]
                arr[l] = arr[l] ^ arr[r];
                arr[r] = arr[l] ^ arr[r];
                arr[l] = arr[l] ^ arr[r];
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = {12, 34, 45, 9, 8, 90, 3};

        segregateEvenOdd(arr);

        System.out.print("Array after segregation ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
