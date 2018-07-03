package com.macquarie.shiner.batch.gcs.tasklet;

/**
 * @author vsingh16
 */
public class MaxLenNonRepeatingSubString {


    public static int maxLen(String str) {

        Integer maxLen = 1;
        int curLen = 1;
        int visited[] = new int[26];
        for (int i = 0; i < 26; i++) {
            visited[i] = -1;
        }
        visited[str.charAt(0) - 'a'] = 0;

        for (int i = 1; i < str.length(); i++) {
            int prevIndex = visited[str.charAt(i) - 'a'];
            //if charatcer is not visited or charter is new to current NRS(non repeating string)
            if (prevIndex == -1 || i - curLen > prevIndex) {
                curLen++;
            } else {
                maxLen = Math.max(curLen, maxLen);
                curLen = i - prevIndex; //next sub string we will consider after the duplicate character
            }

            visited[str.charAt(i) - 'a'] = i;
        }

        return Math.max(curLen, maxLen);

    }

    public static void main(String[] args) {
        System.out.println(maxLen("geeksforgeeks"));
        System.out.println(maxLen("gekesp"));
        System.out.println(maxLen("psgl"));
    }
}
