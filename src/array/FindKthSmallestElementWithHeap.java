/**
** https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
** Approach 1: if we sort array, then a[k-1] is kth smalledt element.
** Time Complexlity: O(nlogn)
**/

public int findKthSmallest(int a[], int k) {            
      Arrays.sort(a);      
      retunr a[k-1];
    }

/**
** Approach 2:Lets take min heap, we know that remove() min heap will always return min element, so remove() k times, will give me kth smallest element.
** Time Complexity : O(n + klogn) which is better than approach 1
**/

public class MinHeap {

    private int a[];
    private int lastPos;

    public MinHeap(int n) {
        this.a = new int[n];
        this.lastPos = -1;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

   //logn: n is no of elements in heap
    public void insert(int element) {

        //full
        if (lastPos == a.length - 1) {
            return;
        }
        a[++lastPos] = element;
        int currentPos = lastPos;
        while (currentPos > 0 && a[currentPos] < a[parent(currentPos)]) {
            swap(a, currentPos, parent(currentPos));
            currentPos = parent(currentPos);
        }
    }

    //thi will return min element
    //log n : n is no of elements in heap
    public int remove() {

        swap(a, 0, lastPos);
        int min = a[lastPos];
        lastPos--;
        int currentPos = 0;
        while (2 * currentPos + 1 <= lastPos && (a[currentPos] > a[left(currentPos)] || a[currentPos] > a[right(currentPos)])) {

            if (a[currentPos] > a[left(currentPos)]) {
                swap(a, currentPos, left(currentPos));
            } else {
                swap(a, currentPos, right(currentPos));
            }

        }

        return min;
    }
}

//O(n+logn)
public int findKthSmallest(int a[], int k) {            
 MinHeap heap = new MinHeap(a.length);
 //Time Complexity of building heap is O(n) .
 //https://www.geeksforgeeks.org/time-complexity-of-building-a-heap/
 //it looks like we are inserting n elements and n times heapify may be called , O(nlogn) 
 //but note that there will not be n elements in array every time, it will only be there after insertion of n elements 
 for (int i = 0; i < a.length; i++) {
            heap.insert(a[i]);
  } 
 int min=-1; 
 while (k > 0) {
            min = heap.remove(); //klogn
            k--;
        }
  return min; 
 }

/**
** Approach 3: Lets take max heap, if we maintain max heap of size K i.e we will remove elements if heap size > k, then first element in max heap will be Kth smallest elemnet
** becuase heap size is K.
** Time Complexity :O(k + (n-k)logK)
** We will build heap of size K and for n-k element heapify will be invoked on heap of size K.
**/

public class MaxHeap {

    private int a[];
    private int lastPos;

    public MaxHeap(int n) {
        this.a = new int[n];
        this.lastPos = -1;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public void insert(int element) {

        //full
        if (lastPos == a.length - 1) {
            return;
        }
        a[++lastPos] = element;
        int currentPos = lastPos;
        while (currentPos > 0 && a[currentPos] > a[parent(currentPos)]) {
            swap(a, currentPos, parent(currentPos));
            currentPos = parent(currentPos);
        }
    }

    //thi will return min element
    public int remove() {

        swap(a, 0, lastPos);
        int max = a[lastPos];
        lastPos--;
        int currentPos = 0;
        while (2 * currentPos + 1 <= lastPos && (a[currentPos] < a[left(currentPos)] || a[currentPos] < a[right(currentPos)])) {

            if (a[currentPos] < a[left(currentPos)]) {
                swap(a, currentPos, left(currentPos));
            } else {
                swap(a, currentPos, right(currentPos));
            }

        }

        return max;

    }
}

public int findKthSmallest(int a[], int k) {            
 MaxHeap heap = new MaxHeap(a.length);
 for (int i = 0; i < a.length; i++) {
            heap.insert(a[i]);
            if(i>=k){
              heap.remove();
            }
  } 
 return a[0];
 }


