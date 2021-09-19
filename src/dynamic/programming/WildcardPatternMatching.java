/**
** https://www.geeksforgeeks.org/wildcard-pattern-matching/
** Given a text and a wildcard pattern, implement wildcard pattern matching algorithm that finds if wildcard pattern is matched with text. The matching should cover the entire text (not partial text).
The wildcard pattern can include the characters ‘?’ and ‘*’ 
‘?’ – matches any single character 
‘*’ – Matches any sequence of characters (including the empty sequence)

For example,

Text = "baaabab",
Pattern = “*****ba*****ab", output : true
Pattern = "baaa?ab", output : true
Pattern = "ba*a?", output : true
Pattern = "a*ab", output : false 
** 
Approach : There are couple of cases to consider:
n = str, m = pattern
1) if n == 0 && m == 0, true
2) if n == 0 && m !=0 , if empty char but pattern is non empty only valid case is if pattern is *
pattern[m-1] == '*', [0][m-1]
3) if n != 0 && m == 0: false
4) if (m-1) == '*', [n][m-1](if non empty string, skip *) || [n-1][m] (if empty string, skip string)
5) if(m-1) == ? [n-1][m-1]
6) else str.charAt(n-1) == pattern.charAt(m-1) && (n-1)(m-1)
**/

class Solution
{
  // Time Complexity : O(2^n), we have two choices in case of *
  int wildCard(String str, String pattern, int n, int m){
     if(n == 0 && m == 0){
       return true;
     }else if(n == 0 && m!=0){
       if(patter.charAt(m-1) == '*'){
         return wildCard(str,pattern, 0, m-1);
       }
     }else if(n !=0 && m == 0){
       return false;
     }else if(pattern.charAt(m-1) == '*'){
       return wildCard(str,pattern, n, m-1) || wildCard(str,pattern, n-1, m);                    
     }else if(pattern.charAt(m-1) == '?'){
        return wildCard(str,pattern, n-1, m-1);  
     }else{
         retrun str.charAt(i-1) == pattern.charAt(j-1)
                    && wildCard(str,pattern, n-1, m-1);
         }
    }
}
  
    // Time Complexity: O(n*m)
    // Space Complexity : O(n*m)
    int wildCard(String pattern, String str)
    {
        int n = str.length();
        int m = pattern.length();
        boolean dp[][] = new boolean[n+1][m+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i ==0 && j !=0){ // if empty char, 
                // we can only have true, if pattern is *
                    if(pattern.charAt(j-1) == '*'){ 
                        dp[i][j] = dp[0][j-1]; // [empty Str : 0] [j-1]
                    }
                }else if(i !=0 && j ==0){
                    dp[i][j] = false;
                }else if(pattern.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else if(pattern.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = str.charAt(i-1) == pattern.charAt(j-1)
                    && dp[i-1][j-1];
                } 
            }
        }
        
        return dp[n][m] ? 1 : 0;
    }
}
