/**
** https://www.geeksforgeeks.org/weighted-job-scheduling/
** https://leetcode.com/problems/maximum-profit-in-job-scheduling/submissions/
** Given N jobs where every job is represented by following three elements of it.

Start Time
Finish Time
Profit or Value Associated (>= 0)
Find the maximum profit subset of jobs such that no two jobs in the subset overlap. 

Example: 

Input: Number of Jobs n = 4
       Job Details {Start Time, Finish Time, Profit}
       Job 1:  {1, 2, 50} 
       Job 2:  {3, 5, 20}
       Job 3:  {6, 19, 100}
       Job 4:  {2, 100, 200}
Output: The maximum profit is 250.
We can get the maximum profit by scheduling jobs 1 and 4.
Note that there is longer schedules possible Jobs 1, 2 and 3 
but the profit with this schedule is 20+50+100 which is less than 250.

** Approach 1: Recursive Solution
** First we will sort array based on their end time, so that we can easily check for overlapping.
** We can either exclude job or include job.
** In case of include job, we need to find out non overlapping job and then add its time to our selected job

** Approach2: Since there are overlapping sub problems, we can apply DP.

** Approach 3: we can reduce time complexity of finding non overlapping sub problem by applying binary search.

**/

class Solution {
        
    
    private int findNonOverlapping(Job[] jobs, int i){
    
        for(int j=i-1;j>=0;j--){
            if(jobs[j].endTime <= jobs[i].startTime){
                return j;
            }
        }
        return -1;
    }
    
  /**
  ** Approach1:
  ** since we have two choices at every point.
  ** and in case of inclusive, we need to traverse array n
  ** Time Complexity : O(n*2^n)
  **/
    public int jobScheduling(Job[] jobs, int n) {
        
        if(n == 1){
          return jobs[n-1].profit;
        }
      
      int include = jobs[n-1].profit;
      int j =  findNonOverlapping(jobs, n-1);
      if(j!=-1){
        include += findNonOverlapping(jobs, j+1);
      }
      
      return Math.max(include, jobScheduling(jobs, n-1));
    }
  

  //Approach 2: DP  
  class Solution {
        
    
    private int findNonOverlapping(Job[] jobs, int i){
    
        for(int j=i-1;j>=0;j--){
            if(jobs[j].endTime <= jobs[i].startTime){
                return j;
            }
        }
        return -1;
    }
    
    /**
    ** Time Complexity : sort O(nlogn)
    ** two loops : O(n*n)
    **/
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = profit.length;
        Job jobs[] = new Job[n];
        for(int i=0;i<n;i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        Arrays.sort(jobs, (i,j) -> i.endTime - j.endTime);
      
        int dp[] = new int[n];
        dp[0] = jobs[0].profit;
        for(int i=1;i<n;i++){
            int include = jobs[i].profit;
            int j = findNonOverlapping(jobs,i);
            if(j!=-1){
                include+= dp[j];
            }
            dp[i] = Math.max(include,dp[i-1]);
        }
        
        return dp[n-1];
    }
        
}
 =======================================================Approach 3=====================================================================
   class Solution {
        
    //Time Complexity : O(log n)
    private int findNonOverlapping(Job[] jobs, int i){
        
        int l = 0, h = i-1;
        int pos = -1;
        while(l<=h){
            int mid = (l+h)/2;
            if(jobs[mid].endTime<=jobs[i].startTime){
                pos = mid;
                l = mid+1;                
            }else{
                h = mid-1;
            }
        }
            
        return pos;
    }
    /**
    ** n loop and in each loop log n search
    ** Time Complexity: O(nlogn)
    **/
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = profit.length;
        Job jobs[] = new Job[n];
        for(int i=0;i<n;i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        Arrays.sort(jobs, (i,j) -> i.endTime - j.endTime);
                
        int dp[] = new int[n];
        dp[0] = jobs[0].profit;
        for(int i=1;i<n;i++){
            int include = jobs[i].profit;
            int j = findNonOverlapping(jobs,i);
            if(j!=-1){
                include+= dp[j];
            }
            dp[i] = Math.max(include,dp[i-1]);
        }
        
        return dp[n-1];
    }
          
}
