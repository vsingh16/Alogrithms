/**
** In combination , we don't need to do rearrangement.
** https://www.youtube.com/watch?v=f6cL-VMIfTY&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=22
** We wil follow same approach where we will go places by places.
** and at each place we will try to put current item. One thing we need to know here is that since it is combination, so 1 2 , we dont need to do 2 1
** To do so, for the next item we will start from last box (in the previous iteration).
**/

class Solution{

  //ci = current item , ti = total item = i.e 2, lb = lastPlace
public static void combination(int places[], int ci, int ti, int lp){
  
  if(ci > ti){
    for(int i=0;i< places.length;i++){
      System.out.print(places[i]);
    }
    System.out.println();
    return;
  }
  
  for(int i=lp+1;i<places.length;i++){
    if(places[i] == 0){
      places[i] == i;
      combination(places, ci + 1, ti,i);
      places[i] == 0;
    }
  }  
}

  psvm{String args[]}{
    int places [] = new int[4];
  combination(places, 1, 2);
  }
  
  
}
