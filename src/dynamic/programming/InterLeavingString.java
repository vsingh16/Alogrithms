package dynamic.programming;

/**
 * http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/
 * <p>
 * Given three strings A, B and C. Write a function that checks whether C is an interleaving of A and B. C is said to be interleaving A and B, if it contains all characters of A and B and order of all characters in individual strings is preserved.
 * For example A = “XXY”, string B = “XXZ” and string C = “XXZXXXY”.
 * <p>
 * Approach:
 * <p>
 * if(char of A matches with char of C, A++ and C++) ||
 * if(char of B matches with char of C, B++ and C++)
 * PS: Note here we have two cases and we need to take either of them
 */
public class InterLeavingString {
    
    
    public static boolean isInterleaving(String s1, String s2, String s3, int n1, int n2, int n3) {

        //if all string traversal is completed
        if (n1 == 0 && n2 == 0 && n3 == 0) {
            return true;
        } else if (n3 == 0) {
            return false;//string 3 is completed and we still have characters left in either s1 or s2
        }

        return s1.charAt(n1-1) == s3.charAt(n3-1) && isInterleaving(s1, s2, s3, n1-1, n2, n3 - 1))
                || s2.charAt(n2-1) == s3.charAt(n3-1) && isInterleaving(s1, s2, s3, n1, n2 - 1, n3 - 1))
    }

    /**
     * A
     * Time Complexity:O(2^n)
     */
    public static boolean isInterleaving(String s1, String s2, String s3, int pos1, int pos2, int pos3) {

        //if all string traversal is completed
        if (pos1 == s1.length() && pos2 == s2.length() && pos3 == s3.length()) {
            return true;
        } else if (pos3 == s3.length()) {
            return false;//string 3 is completed and we still have characters left in either s1 or s2
        }

        return (pos1 < s1.length() && s1.charAt(pos1) == s3.charAt(pos3) && isInterleaving(s1, s2, s3, pos1 + 1, pos2, pos3 + 1))
                || (pos2 < s2.length() && s2.charAt(pos2) == s3.charAt(pos3) && isInterleaving(s1, s2, s3, pos1, pos2 + 1, pos3 + 1));
    }

    /**
     * Time Complexity:O(S1*S2)
     * Space Complexity:O(S1*S2)
     */
   public boolean isInterLeave(String a,String b,String c)
	{
            int n1 = a.length();
            int n2 = b.length();
            int n3 = c.length();
            
            if(n1+n2!=n3){
                return false;
            }
            
            boolean dp[][] = new boolean[n1+1][n2+1];
            for(int i=0;i<=n1;i++){
                for(int j=0;j<=n2;j++){
                    int k = i+j;
                    if(i == 0 && j== 0){
                        dp[i][j] = true;
                    }else if(i == 0){ // if s1 is empty, compare s2 and s3
                        if (b.charAt(j - 1) == c.charAt(j - 1)){
                         dp[i][j] = dp[i][j - 1];   
                        }
                    }else if(j==0){ // if s2 is empty, compare s1 and s3
                        if (a.charAt(i - 1) == c.charAt(i - 1)){
                         dp[i][j] = dp[i-1][j];   
                        }
                    }else{
                        dp[i][j] = 
                        (a.charAt(i-1) == c.charAt(k-1) ? dp[i-1][j] : false) 
                        ||
                        (b.charAt(j-1) == c.charAt(k-1) ? dp[i][j-1] : false) ;
                    }
                }
            }
            
            return dp[n1][n2];
	}
}

    public static void main(String[] args) {
        System.out.println(isInterleaving("xxy", "xxz", "xxzxxy", 0, 0, 0));//true
        System.out.println(isInterleavingDyn("xxy", "xxz", "xxzxxy"));//true
        System.out.println(isInterleavingDyn("xxy", "xxz", "xxzxyx"));//false
    }
}
