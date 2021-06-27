/**
** https://leetcode.com/problems/4sum/
** https://www.youtube.com/watch?v=8ViERnSgPKs&t=312s
** Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
**/

class Solution {

  /**
  ** Approach 1: Have 4 loop
  ** We have sorted array first.
  ** inorder to prevent duplicate indexes , next nested loop is starting from +1
  ** Since array is sorted and if two adjacent indexes are same, we will skip that index . [2,2,2,2] sum = 8
  ** And if any point sum is greate than target we can break can come out of loop.
  ** TimeComplexity: O(nlongn + n4) = O(n^4)
  **/
  public List < List < Integer >> fourSum(int[] arr, int target) {
    List < List < Integer >> result = new ArrayList();
    Arrays.sort(arr);
    int n = arr.length;
    for (int i = 0; i < n - 3; i++) {
      //if this arr[i] is same as previous one, skip
      if (i > 0 && arr[i - 1] == arr[i]) {
        continue;
      }
      for (int j = i + 1; j < n - 2; j++) {

        //if this arr[j] is same as previous one, skip
        if (j > i + 1 && arr[j - 1] == arr[j]) {
          continue;
        }

        for (int k = j + 1; k < n - 1; k++) {
          //if this arr[k] is same as previous one, skip
          if (k > j + 1 && arr[k - 1] == arr[k]) {
            continue;
          }

          for (int l = k + 1; l < n; l++) {
            //if this arr[l] is same as previous one, skip
            if (l > k + 1 && arr[l - 1] == arr[l]) {
              continue;
            }

            int sum = arr[i] + arr[j] + arr[k] + arr[l];
            if (sum == target) {
              List < Integer > list = List.of(arr[i], arr[j], arr[k], arr[l]);
              result.add(list);
              break;
            } else if (sum > target) {
              break;
            }
          }
        }
      }
    }
    return result;
  }
 
 class Solution {
  /**
  ** Approach 2: Two pointer .
  ** First sort
  **  We have reduce loop 3 and loop 4 into two pointers.
  ** left = j+1 and right = n-1
  ** if sum found , l++
  ** if sum < target, l++
  ** if sum > target, r--
  ** Skip same element.
  ** Time Complexity: O(n^3)
  **/
  public List < List < Integer >> fourSum(int[] arr, int target) {
    List < List < Integer >> result = new ArrayList();
    Arrays.sort(arr);
    int n = arr.length;
    for (int i = 0; i < n - 3; i++) {
      if (i > 0 && arr[i - 1] == arr[i]) {
        continue;
      }
      for (int j = i + 1; j < n - 2; j++) {
        if (j > i + 1 && arr[j - 1] == arr[j]) {
          continue;
        }

        int left = j + 1;
        int right = n - 1;
        while (left < right) {
          if(left > j+1 && arr[left] == arr[left-1]){
              left++;
          }  
          else if(right < n-1 && arr[right] == arr[right+1]){
              right --;
          }else{
          int sum = arr[i] + arr[j] + arr[left] + arr[right];
          if (sum == target) {
            List < Integer > list = List.of(arr[i], arr[j], arr[left], arr[right]);
            result.add(list);
            left++;
          } else if (sum > target) {
            right--;
          } else {
            left++;
          }    
          }
          
        }
      }
    }
    return result;
  }
}
 }

PS: Sometimes it is asked to print one of such quads, then in that case we use Map but with hashmap usage we face problem of duplicates in result which are hard to 
eliminate considering their order.
Time Complexity of below solution is O(n^2) but will only work if we need to print one of such quad.
class Solution {

  class Pair {
    private int x;
    private int y;
    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public List < List < Integer >> fourSum(int[] arr, int target) {
    Arrays.sort(arr);
    int n = arr.length;
    Map < Integer, List < Pair >> map = new HashMap();
    for (int i = 0; i < n - 3; i++) {
      for (int j = i + 1; j < n - 2; j++) {
        int sum = arr[i] + arr[j];
        if (!map.containsKey(sum)) {
          List < Pair > list = new ArrayList();
          list.add(new Pair(i, j));
          map.put(sum, list);
        } else {
          List < Pair > list = map.get(sum);
          list.add(new Pair(i, j));
        }
      }
    }

    List < List < Integer >> result = new ArrayList();    
    for (int k = 2; k < n - 1; k++) {
      //if this arr[i] is same as previous one, skip
      if (k > 2 && arr[k - 1] == arr[k]) {
        continue;
      }
      for (int l = k + 1; l < n; l++) {
        //if this arr[j] is same as previous one, skip
        if (l > k + 1 && arr[l - 1] == arr[l]) {
          continue;
        }
        int val = target - (arr[k] + arr[l]);
        if (map.containsKey(val)) {
          List < Pair > pairs = map.get(val);
          for (Pair pair: pairs) {        
                if (pair.x != k && pair.x != l && pair.y != k && pair.y != l) {
                Set < Integer > list = new HashSet();
                list.add(arr[pair.x]);
                list.add(arr[pair.y]);
                list.add(arr[k]);
                list.add(arr[l]);            
                resultSet.add(list);
                }                
              
          }
        }
      }
    }
    
    return result;

  }
} 
