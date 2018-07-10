package com.macquarie.shiner.batch.gcs.service;

import java.util.LinkedHashSet;


/**
 * Remove Duplicate characters from String
 */
public class RemoveDuplicateCharacterString {

    /**
     * Approach:Traverse with two loop pointers but disadvantage is we cant ensure
     * characters in result string are in order of original
     * Time Complexity : O(n^2)
     */
    public static String removeDuplicateNaive(String str) {

        String result = "";
        for (int i = 0; i < str.length(); i++) {
            boolean found = false;
            for (int j = i + 1; j < str.length(); j++) {

                if (str.charAt(i) == str.charAt(j)) {
                    found = true;
                }

            }
            if (!found) {
                result = result + str.charAt(i);
            }
        }

        return result;
    }


    /**
     * Approach:Use LinkedHashset to store elements
     * <p>
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static String removeDuplicateWithHash(String str) {

        LinkedHashSet<String> uniqueStringSet = new LinkedHashSet<>();

        for (int i = 0; i < str.length(); i++) {
            uniqueStringSet.add(String.valueOf(str.charAt(i)));
        }

        return uniqueStringSet.stream().reduce("", String::concat);

    }

    /**
     * Approach : Check if char is not there in result string add it to result.
     * <p>
     * Time Complexity :O(n^2)
     * Space Complexity :O(1)
     */
    public static String removeDuplicateWithIndexOf(String str) {

        String result = new String();
        for (int i = 0; i < str.length(); i++) {
            if (result.indexOf(str.charAt(i)) < 0) {
                result = result + str.charAt(i);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(removeDuplicateNaive("TALAT"));
        System.out.println(removeDuplicateWithHash("TATLAT"));
        System.out.println(removeDuplicateWithIndexOf("TATLAT"));
    }
}
