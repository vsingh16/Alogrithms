package com.macquarie.shiner.batch.gcs.tasklet;

/**
 * @author vsingh16
 *         <p>
 *         https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
 */
public class FindFirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String str) {

        int count[] = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            count[ch - 'a'] += 1;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            if (count[ch - 'a'] == 1) {
                return ch;
            }
        }

        return '-';
    }


    public static void main(String[] args) {

        System.out.println(findFirstNonRepeatingChar("geeksforgeeks"));
        System.out.println(findFirstNonRepeatingChar("geeks"));
    }

}
