/**
** https://www.geeksforgeeks.org/min-heap-in-java/
**/

class MinHeap{

  private int arr[];
  private int lastPos;

  MinHeap(int n){
    this.arr = new int[n];
    this.lastPos = - 1;
  }

  private void swap(int a[], int i, int j){
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  private int parent(int index){
    return (index - 1)/2;
  }

  private int left(int index){
    return 2 * index + 1;
  }

  private int right(int index){
    return 2 * index + 2;
  }


  //1. insert at last pos.
  //2. keep comparing with its parent and swap in case if it is min than its parent
  //3. Time Complexity : O(log n)
  public void insert(int element){

    if(lastPos == arr.length - 1){
      return ;
    }

    arr[lastPos++] = element;
    int currentPos = lastPos;

    while(parent(currentPos)>=0 && arr[currentPos] < arr[parent(currentPos)]){
      swap(arr,currentPos, parent(currentPos));
      currentPos = parent(currentPos);
    }
  }

  //1. swap 0th index with lastPos
  //2. we will begin from 0th index(parent) and compare it with its children left & right. If it is greater, swap it 
  public int remove(){
    swap(arr,0,lastPos);
    int min = arr[lastPos];
    lastPos--;
    int currentPos = 0;
  while(!isLeaf(currentPos) && (arr[currentPos] > arr[left(currentPos)] || arr[currentPos] > arr[right(currentPos)] )){
    if(arr[currentPos] > arr[left]){
    swap(arr,currentPos, left(currentPos));
  }else {
  swap(arr,currentPos, right(currentPos));
  }
  }
  return min;
}

  private boolean isValid(int index){
    return index <= (lastpos - 1)/2 ;    
  }
  
  //our left <= lastpos , 2 * i +1 < size
  public void print(){
    for(int i=0; i <= (lastpos - 1)/2;i++){
      System.out.println("Parent : "+ arr[i]);
      System.out.println("Left : "+ 2 * i + 1);
      System.out.println("Right : "+ 2 * i + 2);
    }
  }

}

