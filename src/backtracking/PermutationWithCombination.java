/**
** https://www.youtube.com/watch?v=NWFpebVkmTI&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=21
** In order to find permutation, we will apply combination algorithm.
** i.e we will go box by box but at this time at each box we will have 3(r item) options. to select nothing, select 1 or  select 2 etc.
**
**/
Permutation = Combination * rearrange

2p2 
Box1 = {,,,}{1,,,}{2,,,}
Box2 = {,,,}{,1,,}{,2,,}{1,,,}{1,1,,}{1,2,,}{2,,,}{2,1,,}{2,2,,}

public static void permutations(int cb, int tb, int items[], int ssf, int ts, String asf){
	
	if(cb > tb){
		if(ssf == ts){
			System.out.println(asf);
		}
		return;
	}

    for(int i=0;i< ts;i++){
		if(items[i] == 0){
		   items[i] = 1;
		   permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i+1)); //selected
		   items[i] = 0;
		}
	}	
	permutations(cb + 1, tb, items, ssf, ts, asf+0); //not selected
	

}

