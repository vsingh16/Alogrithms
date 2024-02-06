package com.macquarie.shiner.batch.gcs.processor;

import java.util.HashMap;
import java.util.Map;

/**
** Majority Element: Find the majority element in the array. A majority element in an array A[] of size n is an element that appears more than n/2 times
** (and hence there is at most one such element). 
** Input : A[]={3, 3, 4, 2, 4, 4, 2, 4, 4}
** Output : 4
** Explanation: The frequency of 4 is 5 which is greater than the half of the size of the array size. 

** Input : A[] = {3, 3, 4, 2, 4, 4, 2, 4}
** Output : No Majority Element
** Explanation: There is no element whose frequency is greater than the half of the size of the array size.
** Approach1: Maintain Freq of element in Map and we can traverse map to check if count >n/2
**  Time Complexity:O(n) & Space Complexity:O(n)
**
** Approach 2: 
** Consider first element as majority element. C = 1
** Compare with other elements. If same, c++ else c--
** if c==0, then this number can't majority number. Becuase majority number will appear at least n/2 + 1
** Reset c = 1, majority = a[I]
** Above will give the probable majority number.
** We need to again check the freq of probable majority number.
** Time Complexity:O(n) & Space Complexity:O(1)
** Ref: https://www.youtube.com/watch?v=YXywKwT9EKA
** https://www.youtube.com/watch?v=3tbjwaGC-ng
**/

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

    //Time Complexity:O(n) & Space Complexity:O(1)
     static int majorityElement(int a[], int n)
    {
        // your code here
        int ma=a[0];
        int c = 1;
        for(int i=1;i<n;i++){
            if(ma == a[i]){
                c++;
            }else{
                c--;
            }
            
            if(c==0){
                ma = a[i];
                c = 1;
            }
        }
        
        c=0;
        for(int i=0;i<n;i++){
            if(a[i] == ma){
                c++;
            }
        }
        
        return (c> n/2) ? ma : -1;
        
        
    }

    public static void main(String[] args) {

        int a[] = {2, 2, 2, 2, 5, 5, 2, 3, 3};
        System.out.println(getMajorityElement(a));

    }
}
