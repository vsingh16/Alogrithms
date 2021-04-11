/**
** https://byjus.com/permutations-and-combinations-formulas/
** Permutation is the way we can arrange r items in n boxes. Here order matters eg : 12, 21 . Non Identocal items
** Combination is the way to select r items and then place them in n boxes. eg: 12 . Here we dont consider there order. Identical items. i.e 12 = 21 is same and consider as
** once combination of 1 and 2.
** 4c2 =
Now
Box 1 = {1,,,}                                               {,,,}
Box 2 = {1,1,,} {,,,}                                        {,1,,} {,,,}
Box 3 = {1,1,1,} {1,1,,} {,,1,}{,,1,}                        {,1,1,} {,1,,} {,,1,} {,,,}
Box 4 = {1,1,1,1}{1,1,1,}{1,1,,1}{1,1,,}{,,1,1}{,,1,}        {,1,1,1}{,1,1,}{,1,,1}{,1,,}{,,1,1}{,,1,}{,,,1}{,,,}
For combination, at each box we are making slection i.e either selected or not?
We only need to print ans. where items in (n)box == r i.e 2
ans: {1,1,,}{1,1,,} {,1,1,}{1,1,,} {,1,,1}{,,1,1}
ncr = npr/r!
**/

public static void combinations(int cb, int tb, int ssf, int ts, String asf){

    if(cb > tb){
	   if(ssf == ts){ // we only need to print ans with r items
	    System.out.println(asf);
	   }
	}

	combinations(cb+1, tb, ssf+1, ts, asf+"i")//selected
	combinations(cb+1, tb, ssf+1, ts, asf+"-")// not selected

}

psvm(){
combinations(1, nboxes, 0, ritems, "")
}
