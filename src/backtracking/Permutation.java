/**
** https://byjus.com/permutations-and-combinations-formulas/
** https://www.youtube.com/watch?v=QKkHCS5bq0I&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=19
** Permutation is the way of arranging r intems in n places.
** eg: 4p2 = 1 = {1,,,} {,1,,} {,,1,} {,,,1}
** 2 = {1,,,} ---> {1,2,,} {1,,2,} {1,,,2}
** {,1,,} ---> {2,1,,}, {,1,2,} {,1,2,} {,1,,2}
** {,1,,} ---> {2,1,,}, {,1,2,} {,1,2,} {,1,,2}
** {,,1,} ---> {2,,1,}, {,2,1,} {,2,1,} {,,1,2}
** {,,,1} ---> {2,,,1}, {,2,,1} {,,2,1} {,,2,1}
** Formuale 
** No of ways to put 1st item = n
** No of ways to put 2nd item = n * n-1
** Npr = n * (n-1) * (n-2) * .......* (n - (r-1))
** Now to make n!, we will *  (n - r)!  
** n * (n-1) * (n-2) * .......* (n - (r-1)) .....(n - r) * (n - r - 1) * (n - r - 2) *......1/  (n - r) * (n - r - 1) * (n - r - 2) *......1
** n!/(n-r)!
**/

class Solution{

  //ci = current item , ti = total item = i.e 2
public static void permutation(int places[], int ci, int ti){
  
  if(ci > ti){
    for(int i=0;i< places.length;i++){
      System.out.print(places[i]);
    }
    System.out.println();
    return;
  }
  
  for(int i=0;i<places.length;i++){
    if(places[i] == 0){
      places[i] == i;
      permutation(places, ci + 1, ti);
      places[i] == 0;
    }
  }  
}

  psvm{String args[]}{
    int places [] = new int[4];
  permutation(places, 1, 2);
  }
  
  
}
