/**
** https://www.geeksforgeeks.org/dsa/rabin-karp-algorithm-for-pattern-searching/
** https://www.youtube.com/watch?v=H4VrKHVG5qI
** Rabin-Karp is:

A string matching algorithm
Uses rolling hash to find all occurrences of a pattern in a text
Optimized for cases where multiple patterns or repeated matching is required
** We have taken formulae for hash, opposite to the one in video.
** ABC = A * pow(Base,2)+ B * pow(Base,1)+ C * pow(Base,0). Here length =3

** Time Complexity : O(n+m) //Best and Avg Case
** Time Complexity: O(n*m) //Worst Case, Since bad hash, we need to compare every time
** Space Complexity: O(1)
**/

class Solution {
    
  // --- Mandatory Constants for Rabin-Karp ---
    private static final long MODULUS = 1000000007L;
    private static final long PRIME = 101;

    private static long calculateRollingHash(String txt, int patternLength, int oldIndex, int newIndex, long oldHash, long h) {

        // Formula: H_new = ((H_old - txt[oldIndex] * h) * PRIME + txt[newIndex]) % MODULUS
        
        // 1. Subtract the leading character's value (txt[oldIndex] * PRIME^(L-1))
        long removedValue = (txt.charAt(oldIndex) * h) % MODULUS;
        
        // Add MODULUS before the final modulo to handle potential negative result from subtraction
        long newHash = (oldHash - removedValue + MODULUS) % MODULUS; 

        // 2. Shift the hash left (multiply by PRIME)
        newHash = (newHash * PRIME) % MODULUS;

        // 3. Add the trailing character's value (txt[newIndex] * PRIME^0)
        newHash = (newHash + txt.charAt(newIndex)) % MODULUS;

        return newHash;
    }

    private static boolean checkIfPatternAndStringEqual(String text, String pattern, int textIndex) {

        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(i + textIndex) != pattern.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private static long pow(long base, int exp) {
      long res = 1;
        base %= MODULUS;
        while (exp > 0) {
            if ((exp & 1) != 0) res = (res * base) % MODULUS;
            base = (base * base) % MODULUS;
            exp >>= 1;
        }
        return res;
    }

    static ArrayList<Integer> search(String pat, String txt) {

        ArrayList<Integer> result = new ArrayList<>();

        // The largest power: PRIME^(M-1) mod MODULUS
        long h = pow(PRIME, pat.length() - 1);

        //Find pattern and initial text hash
        long pHash = 0;
        long prime = 101;
        long tHash = 0;
        for (int i = 0; i < pat.length(); i++) {
            pHash = (pHash + (pat.charAt(i) * pow(PRIME, pat.length() - 1 - i))) % MODULUS;
            tHash = (tHash + (txt.charAt(i) * pow(PRIME, pat.length() - 1 - i))) % MODULUS;
        }

        //Traverse string and compare hash.
        for (int i = 0; i <= txt.length() - pat.length(); i++) {

            if (pHash == tHash && checkIfPatternAndStringEqual(txt, pat, i)) {
                result.add(i);
            }

            //Calculate Rolling Hash
            if (i + pat.length() < txt.length()) {
                tHash = calculateRollingHash(txt, pat.length(), i, i + pat.length(), tHash, h); //i + pat.length() represents last character in rolling string
            }


        }

        return result;

    }

}
