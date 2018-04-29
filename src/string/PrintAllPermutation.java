package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vishal on 29-Apr-18.
 * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * <p>
 * TO print all permutation, swap first character with remaining characters
 * and keep on doing so, for all new strings generated after swapping.
 *
 * Time Complexity:O(n! * n)
 * for a string we have loop and we will have n!permuataion
 */
public class PrintAllPermutation {

    private static Set<String> permutationSet = new HashSet<>();

    private static String swap(String s, int l, int i) {

        char sArr[] = s.toCharArray();
        char temp = s.charAt(l);
        sArr[l] = sArr[i];
        sArr[i] = temp;

        return String.valueOf(sArr);
    }

    public static void printAllPermutation(String s, int l) {

        if (l == s.length() - 1) {
            permutationSet.add(s);
            return;
        }

        for (int i = l; i < s.length(); i++) {

            String newStr = swap(s, l, i);
            printAllPermutation(newStr, l + 1);

        }

    }

    public static void main(String[] args) {
        printAllPermutation("ABC", 0);
        System.out.println(permutationSet);
    }
}
