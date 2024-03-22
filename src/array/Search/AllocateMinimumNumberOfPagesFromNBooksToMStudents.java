/**
** https://www.geeksforgeeks.org/allocate-minimum-number-pages/
** Allocate Minimum Number of Pages from N books to M students
** Given that there are N books and M students. Also given are the number of pages in each book in ascending order. The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum, with the condition that every student is assigned to read some consecutive books. Print that minimum number of pages.
**
** Example : 
** 
** Input: N = 4, pages[] = {12, 34, 67, 90}, M = 2
**
** Output: 113
** Approach 1:
** Ref Link: https://www.youtube.com/watch?v=YTTdLgyqOLY
** Similar Problem: Painters Partition Problem, Aggressive cows	etc
** We can create search space, starting from 0 to sum of array.
** Since array is sorted and we need to assign consecutive pages, we can apply binary search in this search space.
** We can find mid.
** Check if mid is a possible solution, if yes, since we need to find min, store the ans & h = mid - 1
** if not a solution, l = mid + 1;
** Conditions for not a solution
** if no of students > m || a[i] > mid (any page itself is greater than mid value)
** Time Complexity: O(nlogn)
** Space Complexity: O(1)
**/

class Solution 
{
    
    public static boolean isPossibleSol(int[]a,int n,int m, int mid){
        
        int studentCount=1;
        int sum=0;
        for(int i=0;i<n;i++){
            
            if(sum + a[i] <= mid){
               sum = sum + a[i] ;
            }else{
               studentCount++;
               sum = a[i];
               
               if(studentCount > m || a[i] > mid){ //student count is more than given student or any book has more pages than mid which we are thinking as solution
                   return false;
               }
            }
            
        }
        
        return true;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]a,int n,int m)
    {
        
        if(m > n){ //no of student is greater than books
            return -1;
        }
        int l =0;
        int h = Arrays.stream(a).sum();
        int ans = -1;
        
        while(l<=h){
            int mid = l + (h-l)/2;
            if(isPossibleSol(a,n,m,mid)){
                ans = mid;
                h = mid - 1;
            }else{
              l = mid + 1;   
            }
        }
        
        return ans;
    }
};
