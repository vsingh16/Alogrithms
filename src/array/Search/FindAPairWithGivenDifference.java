/**
** Find a pair with the given difference
** Given an unsorted array and a number n, find if there exists a pair of elements in the array whose difference is n. 
** Examples: 

** Input: arr[] = {5, 20, 3, 2, 50, 80}, n = 78
** Output: Pair Found: (2, 80)

** Input: arr[] = {90, 70, 20, 80, 50}, n = 45
** Output: No Such Pair
** Ref: https://www.youtube.com/watch?v=XGrXiVi7Ces&t=154s
** Approach 1:
** Brute force, find a[i]-a[j] == K.
** Time Complexity: O(n^2). Space Complexity: O(1)
**
** Approach 2:
** Sort an array
** i=0, j=1
** find a[j]-a[i]
* Case 1: a[j]-a[i] == k -> return 
** Case 2: a[j]-a[i] < k -> j++. Since distance is less than k and array is sorted, we need to increase value of j
** Case 3: a[j]-a[i] > k -> i++. Since distance is greater than k and array is sorted, we need to increase value of i
** Time Complexity: O(nlogn). Space Complexity: O(1)
** Ref: https://www.youtube.com/watch?v=XGrXiVi7Ces&t=154s
** 
**/
