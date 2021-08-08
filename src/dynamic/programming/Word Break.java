/**
** https://leetcode.com/problems/word-break/submissions/
** Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

** Approach: we will check if entire word is in dictionary, return true
** else we need to partiton string into substrings strating from (0,1) & (1)...and so on and see if both sub string after partition eixst , then true else false

** Now in recursion, we can apply above concept , since there will be overlapping sub problems, we can apply DP too.

** DP Approach : we can dp[string len+1]
** and start filling this array in bottom up approach.
**/

class Solution {
    /**
    ** DP bottom up approach: 
    ** Time Complexity : O(n^2)
    ** Space Complexity : O(n)
    **/
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;//substring(0,0) empty substring true
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
              //j = 0, will give use entire string without any  partion
              //afterwards, j will be paritioning we have alreay the result of dp[j] && substring(j,i)
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
        
    }
  //Time Complexity:
  public boolean wordBreak(String s, List<String> wordDict) {
        
        if (wordDict.contains(s)) {
            return true;
        } else {
            for (int i = 1; i < s.length(); i++) {
                if (wordBreak(s.substring(0, i), wordDict)
                        && wordBreak(s.substring(i), wordDict)) {
                    return true;
                }
            }
        }

        return false;
        
    }
}
