package com.macquarie.shiner.batch.gcs.config;

/**
 * https://www.geeksforgeeks.org/run-length-encoding/
 */
public class StringCompression {

    public static String compress(String str) {

        if (str == null || str.isEmpty()) {
            return str;
        }

        char chArr[] = str.toCharArray();
        char ch = chArr[0];
        int counter = 1;
        StringBuilder compressedString = new StringBuilder();
        for (int i = 1; i < chArr.length; i++) {

            if (ch == chArr[i]) {
                counter++;
            } else {
                compressedString = counter > 1 ? compressedString.append(ch).append(counter) : compressedString.append(ch);
                ch = chArr[i];
                counter = 1;
            }
        }

        compressedString = counter > 1 ? compressedString.append(ch).append(counter) : compressedString.append(ch);

        return compressedString.toString();
    }


    public static void main(String[] args) {

        System.out.println(compress("aaabbaa"));
        
    }
}
