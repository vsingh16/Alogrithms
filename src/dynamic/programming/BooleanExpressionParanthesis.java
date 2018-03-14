package dynamic.programming;

/**
 * Created by vishal on 14-Mar-18.
 */

/**
 * Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
 * Symbols
 * 'T' ---> true
 * 'F' ---> false
 * *
 * Operators
 * &   ---> boolean AND
 * |   ---> boolean OR
 * ^   ---> boolean XOR
 * <p>
 * Input: symbol[]    = {T, F, T}
 * operator[]  = {^, &}
 * Output: 2
 * The given expression is "T ^ F & T", it evaluates true
 * in two ways "((T ^ F) & T)" and "(T ^ (F & T))"
 * <p>
 * Input: symbol[]    = {T, F, F}
 * operator[]  = {^, |}
 * Output: 2
 * The given expression is "T ^ F | F", it evaluates true
 * in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )".
 * <p>
 * Input: symbol[]    = {T, T, F, T}
 * operator[]  = {|, &, ^}
 * Output: 4
 * The given expression is "T | T & F ^ T", it evaluates true
 * in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T)
 * and (T|((T&F)^T)).
 */
public class BooleanExpressionParanthesis {

    private static int countParenth(char symb[], char oper[]) {

        int n = symb.length;

        if (n == 0) {
            return 0;
        }

        int T[][] = new int[n][n];
        int F[][] = new int[n][n];

        //Base Case
        for (int i = 0; i < n; i++) {
            F[i][i] = (symb[i] == 'F') ? 1 : 0;
            T[i][i] = (symb[i] == 'T') ? 1 : 0;
        }

        for (int gap = 1; gap < n; ++gap) {
            for (int i = 0, j = gap; j < n; ++i, ++j) {
                T[i][j] = F[i][j] = 0;
                for (int g = 0; g < gap; g++) {
                    // Find place of parenthesization using current value
                    // of gap
                    int k = i + g;

                    // Store Total[i][k] and Total[k+1][j]
                    int tik = T[i][k] + F[i][k];
                    int tkj = T[k + 1][j] + F[k + 1][j];

                    // Follow the recursive formulas according to the current
                    // operator
                    if (oper[k] == '&') {
                        T[i][j] += T[i][k] * T[k + 1][j];
                        F[i][j] += (tik * tkj - T[i][k] * T[k + 1][j]);
                    }
                    if (oper[k] == '|') {
                        F[i][j] += F[i][k] * F[k + 1][j];
                        T[i][j] += (tik * tkj - F[i][k] * F[k + 1][j]);
                    }
                    if (oper[k] == '^') {
                        T[i][j] += F[i][k] * T[k + 1][j] + T[i][k] * F[k + 1][j];
                        F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];
                    }
                }
            }
        }
        return T[0][n - 1];

    }

    public static void main(String[] args) {
        char symb[] = {'T', 'F', 'T'};
        char operators[] = {'^', '&'};
        System.out.println(countParenth(symb, operators));

    }


}
