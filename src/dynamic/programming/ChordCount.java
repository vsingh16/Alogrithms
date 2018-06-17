package dynamic.programming;

/**
 * Created by vishal on 06-Mar-18.
 * <p>
 * Given a number N, find the number of ways you can draw N chords in a circle with 2*N points such that no 2 chords intersect.
 * <p>
 * Input : N = 2
 * Output : 2
 * Explanation: If points are numbered 1 to 4 in
 * clockwise direction, then different ways to
 * draw chords are:
 * {(1-2), (3-4)} and {(1-4), (2-3)}
 * <p>
 * <p>
 * Input : N = 1
 * Output : 1
 * Explanation: Draw a chord between points 1 and 2.
 * *
 * n chords = 2*n points on circle.
 * <p>
 * eg 2 chords = 2*2 4 points
 * <p>
 * if point 1 joins point 2, there are no points left on this chord while there are two points(3,4) on other chord side.
 * f(0)*f(2)
 * <p>
 * if point 1 joins point 3, there is one point(2) left on this chord and one point(4) on other chord side.
 * f(1)*f(2)
 * <p>
 * if point 1 joins point 4, there are no points left on this chord while there are two points(2,3) on other chord side.
 * f(2)*f(0)
 * <p>
 * Total Ways f(2) = f(0)f(2)+f(1)f(1)+f(2)f(0)
 * ChordCount(n) = Catlan(n)
 */
public class ChordCount {

    static int chordCnt(int A) {

        // n = no of points required
        int n = 2 * A;

        // dp array containing the sum
        int[] dpArray = new int[n + 1];
        dpArray[0] = 1; //if no points, nothing need to do,and circle's representation =1
        dpArray[2] = 1;  //if tow points, only one chord can be drawn and in one way
        ///for odd cases, value will always be zero
        for (int i = 4; i <= n; i += 2) {
            for (int j = 0; j < i - 1; j += 2) {
                dpArray[i] += (dpArray[j] * dpArray[i - 2 - j]);
            }
        }

        // returning the required number
        return dpArray[n];
    }

    public static void main(String[] args) {
        int N;
        N = 2;
        System.out.println(chordCnt(N));
        N = 1;
        System.out.println(chordCnt(N));
        N = 4;
        System.out.println(chordCnt(N));
    }

}
