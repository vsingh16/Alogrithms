/**
* Find kth largest element in given array.
* There are two methods: 
* Method 1: First sort element.
* Return kth element. Time Complexity : O(n log n) : 
*
* Method 2: With below approach, you can find kth largest element in O(n) time in average case.
* But in worst case scenario, Time Complexity : O(n^2) i.e if array is already sorted in reverse order.
* This method is simialr to quick sort, where we find pivot index.( i.e less < pivot < greater)
* Step 1: Find Pivot Index
*  Step 1.1: Traverse from righ to left, keep i  = r, pivot = l
*  Step 1.2: if element is greate than pivot , move it to extreme right 
* Step 2: if element at index is the dersired kth, return element 
* Step 3: if k is less  than pivot index, it means we need to go on right side else on left
* Step 4: when we go on left side, we need to update k as we have discarded r-pivot +1 elements.
**/
class Solution {
    
public static int findKthElement(int a[],int l, int r, int k){

  //Base Condition: array must have elements greater or equal to k
  if(k<=0 && k > (r-l + 1)){
    return -1;
  }

  else if(l == r & k == 1){
    return a[l];
  }

  int index = findPivotIndex(a,l,r);
  //case 1 : i.e when pivot index is equal to kth element
  if(r - index == k-1){
	  return a[index];
  }
  
  //case 2 : right side
  else if(r - index > k-1 ){
   return findKthElement(a,index +1 , r, k);
  }
  
  //case 3: left side
  else {
   return findKthElement(a,l , index - 1 , k - (r - index + 1));
  }
}

 public static int findPivotIndex(int a[], int l, int r){

  int i = r;
  int pivot = l;
  for(int j = r;j>=pivot+1;j--){
    if(a[j]> a[pivot]){
      swap(a,i,j);
      i--;
    }
  }
  swap(a,i,pivot);
  return i;
}

public static void swap(int a[], int i, int j){
  int temp = a[i];
  a[i] = a[j];
  a[j] = temp;
}
       
    public static int findKthLargest(int[] nums, int k) {
        return findKthElement(nums,0,nums.length-1,k);       
    }
}
