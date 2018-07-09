/**
 * Created by vishal on 09-Jul-18.
 * <p>
 * https://www.geeksforgeeks.org/find-water-in-a-glass/
 * <p>
 * As per pascal, number of elements in a row = row index
 * <p>
 * Total elements in pascal trianlge = row * (row+1)/2
 * <p>
 * Time complexity : O(r*c)
 * Space Complexity:O(r^2)
 */
public class WaterGlassPuzzle {

    public static float findWater(int r, int c, int x) {

        float glass[] = new float[(r * (r + 1)) / 2];
        glass[0] = x;
        int index = 0;
        for (int i = 1; i < r; i++) {
            for (int j = 1; j <= i; j++) {
                float current = glass[index];//get current water
                glass[index] = glass[index] >= 1 ? 1 : 0;//current glass can hold upto 1 ltr only
                float rem = current >= 1 ? (current - 1) : 0;
                glass[index + i] = rem / 2; //put the remainign in lower two glasses
                glass[index + i + 1] = rem / 2;
                index++;
            }
        }

        //in previous row = (r-1), total elements = (r-1)*(r-1 +1)/2
        //then add number of columns since we started from zero -1
        int requiredIndex = (((r - 1) * (r - 1 + 1)) / 2) + c - 1;
        return glass[requiredIndex];

    }

    public static void main(String[] args) {

        System.out.println(findWater(2, 2, 2));
    }
}
