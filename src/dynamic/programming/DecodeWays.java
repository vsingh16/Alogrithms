package dynamic.programming;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * 'Z' -> 26
 * Input:  digits[] = "121"
 * Output: 3 , "ABA", "AU", "LA"
 */
public class DecodeWays {

    public static int numDecodings(String input) {

        return numDecodingsRec(input, input.length());
    }

    //Time Complexity:Exponential
    public static int numDecodingsRec(String input, int n) {

        //case like "0799733" or "0" , as we cant decode "0"
        if (n > 0 && (input.substring(0, n).isEmpty() || "0".equals(input.substring(0, n)))) {
            return 0;
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        int count = 0;
        //because if digit is zero then in case of single value no representation is possible as 1-26 = A-Z and two digits are possbile eg 10
        if (input.charAt(n - 1) > '0') {
            count = numDecodingsRec(input, n - 1);
        }

        if (input.charAt(n - 2) == '1' || (input.charAt(n - 2) == '2' && input.charAt(n - 1) <= '6')) {
            count += numDecodingsRec(input, n - 2);
        }

        return count;
    }

    //Time Complexity:O(n)
    //Space:O(n)
    public static int numDecodingsDyn(String input, int n) {

        //case like "0799733" or "0" , as we cant decode "0"
        if (n > 0 && (input.charAt(0) == '0')) {
            return 0;
        }

        int count[] = new int[n + 1];
        count[0] = 1;
        count[1] = 1;

        //i = length
        for (int i = 2; i <= n; i++) {

            if (input.charAt(i - 1) > '0') {
                count[i] = count[i - 1];
            }

            if (input.charAt(i - 2) == '1' || (input.charAt(i - 2) == '2' && input.charAt(i - 1) <= '6')) {
                count[i] += count[i - 2];

            }
        }

        return count[n];
    }

    //Time Complexity:O(n)
    //Space:O(1)
    public static int numDecodingsFabbonaci(String input, int n) {

        //case like "0799733" or "0" , as we cant decode "0"
        if (n > 0 && (input.charAt(0) == '0')) {
            return 0;
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        int a = 1, b = 1, c = 0;
        //i = length
        for (int i = 2; i <= n; i++) {
            if (input.charAt(i - 1) > '0') {
                c = b;
            }

            if (input.charAt(i - 2) == '1' || (input.charAt(i - 2) == '2' && input.charAt(i - 1) <= '6')) {
                c += a;
            }
            a = b;
            b = c;
        }

        return c;
    }


    public static void main(String[] args) {
        System.out.println(numDecodings(""));
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("0799733"));
        System.out.println(numDecodings("121"));//output :3
        System.out.println(numDecodings("1234"));//output :3

        System.out.println(numDecodingsFabbonaci("1234", 4));
        System.out.println(numDecodingsFabbonaci("121", 3));
        System.out.println(numDecodingsFabbonaci("0123", 3));
        System.out.println(numDecodingsFabbonaci("",0));
    }

}
