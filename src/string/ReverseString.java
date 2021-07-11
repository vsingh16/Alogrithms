/**
** https://www.youtube.com/watch?v=WEmuz4x7yMI&list=PLDdcY4olLQk3zG-972eMoDJHLIz3FiGA6&index=1
** we need to revrse givcen String eg:
** input: VISHAL
** OUTPUT: LAHSIV
**
**/

Approach1:
Time Complexity : O(N)
Space Complexity :O(N)  
int n = input.length;
char result[] = new char[n];
for(int i=0;i<n;i++){
  result[i] = input[n-i];
}

Approach2: We will do inplace string update to reduce need to extra string.
Time Complexity : O(N)
int n = input.length;
int start=0;
int end = n-1;
while(start<end){
  input[start++] = input[end--];
}
