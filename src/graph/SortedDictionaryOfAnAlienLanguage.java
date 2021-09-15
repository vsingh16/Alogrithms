/**
** https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
** Given a sorted dictionary of an alien language, find order of characters
Difficulty Level : Hard
Last Updated : 13 Sep, 2021
Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.

Examples:  

Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
Output: Order of characters is 'b', 'd', 'a', 'c'
Note that words are sorted and in the given language "baa" 
comes before "abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.

Input:  words[] = {"caa", "aaa", "aab"}
Output: Order of characters is 'c', 'a', 'b'

** Approach : Since given array is sorted, we can compare adjacent words to form a graph which will depict
** order of letter.
** Now we can print Topological sorting of graph to print them in order i.e which letter will come after one another.
** We have studied TOPOLIGCAL sort by BFS approach we can apply that, here I am applying Toplogical sort with DFS.
** If we pay attention we can sense that DFS prints the leaf node first and then backtrack to parent.
** Topoligcal sort is start from parent(indegree = 0) and then its children
** i.e topoliogcal sort = reverse DFS
** SO we apply DFS but store result in reverse order.
**/

class Solution
{
 
    String result = "";   
    public void DFS(int node,List<List<Integer>> graph,boolean[] visited){
        
        visited[node] = true;
        for(int neighbour :graph.get(node)){
            if(!visited[neighbour]){
               DFS(neighbour,graph,visited);
            }
        }
        
        char ch = (char)(node+'a');
        result = ch + result; // result in reverse order
    }
    public String findOrder(String [] dict, int N, int K)
    {
        List<List<Integer>> graph = new ArrayList();
        for(int i=0;i<K;i++){
            graph.add(new ArrayList());
        }
        
        for(int i=0;i<N-1;i++){
            String word1 = dict[i];
            String word2 = dict[i+1];
            int l1= word1.length();
            int l2 = word2.length();
            for(int j=0;(j< l1 && j <l2);j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    graph.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
                    break;
                }
            }
        }                
        boolean visited[] = new boolean[K];
        for(int i=0;i<graph.size();i++){
            if(!visited[i]){
             DFS(i,graph,visited);   
            }
        }
        
        return result;
    }
}
