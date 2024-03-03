/**
** https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
** Minimum number of swaps required to sort an array
** Given an array of N distinct elements, find the minimum number of swaps required to sort the array.

Examples: 

Input: {4, 3, 2, 1}
Output: 2
Explanation: Swap index 0 with 3 and 1 with 2 to form the sorted array {1, 2, 3, 4}

Input: {1, 5, 4, 3, 2}
Output: 2
** Approach: We can keep pairs(element, pos).
** Next we can sort array of pairs based on elements.
** Traverse array, if pos == i, no action else move it to pos()
** Ref Link: https://www.youtube.com/watch?v=1BxbBgNSwHo
** Time Complexity: O(nlogn)
** Space Complexity: O(n)
** Ref: https://www.youtube.com/watch?v=1BxbBgNSwHo
**/

class Solution {

    static class Pair {

        private int element;
        private int pos;

        public Pair(int element, int pos) {
            this.element = element;
            this.pos = pos;
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }
    }

    public static int minSwaps(int[] a) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            Pair pair = new Pair(a[i], i);
            pairs.add(pair);
        }

        //sort
        pairs.sort(Comparator.comparingInt(p -> p.element));

        int i = 0;
        int c = 0;
        while (i < pairs.size()) {
            Pair pair = pairs.get(i);
            if (pair.pos != i) {
                //swap pair at i index & pair.pos index
                c++;
                int j = pair.getPos();
                swap(pairs, i, j);
            } else {
                i++;
            }
        }

        return c;

    }

    private static void swap(List<Pair> pairs, int i, int j) {
        Pair temp = pairs.get(i);
        pairs.set(i, pairs.get(j));
        pairs.set(j, temp);

    }


    public static void main(String[] args) {
        int a[] = {4, 3, 2, 1};
        int count = minSwaps(a);
        System.out.println(count);
    }
}


