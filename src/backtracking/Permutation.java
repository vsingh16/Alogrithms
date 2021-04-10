/**
** https://byjus.com/permutations-and-combinations-formulas/
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
