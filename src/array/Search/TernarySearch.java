
/**
** https://www.geeksforgeeks.org/ternary-search/
** Just like Binary Search, in ternary search search space is divided into 3 parts.
** Binary search is best to search in monotonic function(sorted or either increasing or decreasing).
** Ternary search is used to search in unimodal function (like parabola, first increasing and then decreasing or vice versa).
** Quadratic expressions create Parabola/unimodal.
** Time Complexity: 2* O(log3n) // log3n because search space is divided into 3 parts and later 2 * is as no of operations are double.
** This is higher than binary search time complexity.
** Ref: https://www.geeksforgeeks.org/ternary-search/
** https://www.youtube.com/watch?v=FPvvzOPXsrM&list=PL-Jc9J83PIiGiFr2WFAiS9nEssqEoCKC4&index=2 //PrepCoding
** 
**/




class Solution{

    static int ternarySearch(int a[], int n, int search)
    {
        
        int l = 0,r= n-1;
        while(l<=r){
            
            int mid1 = l + (r-l)/3;
            int mid2 = r - (r-l)/3;
            
            if(a[mid1] == search){
                return 1;
                //return mid1;
            }else if(a[mid2] == search){
                return 1;
                //return mid2;
            }else if(search < a[mid1]){
                r = mid1 - 1;
            }else if(search > a[mid2]){
                l = mid2 + 1;
            }else{
                l = mid1 + 1;
                r = mid2 - 1;
            }
        }
        
        return -1;
    }
}
