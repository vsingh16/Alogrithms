/**
** Find min and max in an array
** eg : {10,4,1,2,80}.
** min = 1, max = 80
** Appraoch 1: Sort, min = a[0] and max = a[n-1] , Time Complexity : O(nlogn)
** Approach 2: Min = a[0], Max = a[0], iterate afterwards in array, if a[i] < min, min = a[i]
** a[i] > max, max = a[i]
** Time Complexity: O(n)
** https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
**/
