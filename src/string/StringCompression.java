package com.macquarie.shiner.batch.gcs.config;

/**
 * https://www.geeksforgeeks.org/run-length-encoding/
 ** https://leetcode.com/problems/string-compression/description/
 */
class Solution {

    public static int compress(char[] chars) {

        int pos = 0; // This is to track unique characters
        int counter = 1;
        int totalLength = 0;
        char[] counterCharacter = {};
        int lastUpdatedPos = 0; //Last pos since we are updating the original string
        for (int i = 1; i < chars.length; i++) {

            if (chars[i] == chars[pos]) {
                counter++;
            } else {
                chars[lastUpdatedPos++] = chars[pos];
                totalLength++;
                //add counter in String
                if (counter > 1) {
                    counterCharacter = String.valueOf(counter).toCharArray();
                    for (int j = 0; j < counterCharacter.length; j++) {
                        chars[lastUpdatedPos++] = counterCharacter[j];
                    }
                    totalLength = totalLength + counterCharacter.length;
                }
                pos = i;
                counter = 1;
            }
        }

        //Last character
        chars[lastUpdatedPos++] = chars[pos];
        totalLength++;
        //add counter in String
        if (counter > 1) {
            counterCharacter = String.valueOf(counter).toCharArray();
            for (int j = 0; j < counterCharacter.length; j++) {
                chars[lastUpdatedPos++] = counterCharacter[j];
            }
            totalLength = totalLength + counterCharacter.length;
        }


        System.out.println(chars);
        return totalLength;

    }

    public static void main(String[] args) {

        char[] chars = {'a'};
        System.out.println("Original String");
        System.out.println(chars);
        System.out.println(compress(chars));

    }


}

