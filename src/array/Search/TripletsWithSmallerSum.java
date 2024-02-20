/**
** https://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
** Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value. The expected Time Complexity is O(n2).
** Input : arr[] = {-2, 0, 1, 3}
 **       sum = 2.
** Output : 2
** Explanation :  Below are triplets with sum less than 2
** (-2, 0, 1) and (-2, 0, 3) 
** 
** Input : arr[] = {5, 1, 3, 4, 7}
 **       sum = 12.
** Output : 4
** Explanation :  Below are triplets with sum less than 12
 **              (1, 3, 4), (1, 3, 5), (1, 3, 7) and 
 **              (1, 4, 5)
 ** Approach1: 3 loops. Time Complexity : O(n^2)
 ** Approach 2: Sort array.3 pointers.
 ** a[i]+a[j]+a[k] >= sum, we need to decrease, so k--
 ** else
 ** we need to count.Because i & j is fixed and we got 1 triplet (i,j,k) and array is sorted. values b/w j and k will be decreasing and hence we can get more triplets.
 ** After that we can generate new tripletes with j++;
 ** https://www.youtube.com/watch?v=9455buJlb_k
**/

class Solution
{
    long countTriplets(long a[], int n,int sum)
    {
        Arrays.sort(a);
        int count = 0;
        for(int i=0;i<n-2;i++){
            int j=i+1;
            int k = n-1;
            while(j<k){
                if(a[i]+a[j]+a[k] >= sum){ //we need to decrease, so k--
                    k--;
                }else{
                    count = count + (k-j); //we need to count.Because i & j is fixed and we got 1 triplet (i,j,k) and array is sorted. values b/w j and k will be decreasing and hence we can get more triplets.
                    j++; //After that we can generate new tripletes with j++;
                }
            }
        }
        
        return count;

    }
}
