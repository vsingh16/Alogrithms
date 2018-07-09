package com.macquarie.shiner.batch.gcs.processor;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/majority-element/

public class MajorityElement {

    //Time Complexity:O(n)
    //Space Complexity:O(n)
    private static int getMajorityElement(int a[]) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], 1);
            } else {
                map.put(a[i], map.get(a[i]) + 1);
            }

            if (map.get(a[i]) > a.length / 2) {
                return a[i];
            }

        }

        return -1;
    }

    public static void main(String[] args) {

        int a[] = {2, 2, 2, 2, 5, 5, 2, 3, 3};
        System.out.println(getMajorityElement(a));

    }
}
