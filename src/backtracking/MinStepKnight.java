/**
** https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
** Given a square chessboard of N x N size, the position of Knight and position of a target is given.
** We need to find out the minimum steps a Knight will take to reach the target position.
** Approach: Since it is min distance and one path, we will apply BFS
** https://www.geeksforgeeks.org/difference-between-bfs-and-dfs/#:~:text=BFS%20is%20more%20suitable%20for,used%20in%20games%20or%20puzzles.
** We will apply BFS or Node level in tree approach.
** At every step, we have 8 possible moves for knight. Explore all moves by adding them to queue.
** Also mark node which is added to queue as visisted to avoid including node which is already there in answer.
** Time Complexity: O(n * n)
** Space Complexity : O(n * n)
**/

class Solution
{
    
    class Node{
        
        int x;
        int y;
        int distance;
        Node(int x,int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
    
        int sourceX = KnightPos[0]-1;
        int sourceY = KnightPos[1]-1;
        
        int targetX = TargetPos[0]-1;
        int targetY = TargetPos[1]-1;
        
        // Possible Coordinates
        int dx[] = {-2,-2,2,2,-1,1,-1,1};
        int dy[] = {-1,1,-1,1,-2,-2,2,2};
        
        boolean visited[][] = new boolean[N][N];
        Node firstNode = new Node(sourceX,sourceY,0);
        Queue<Node> queue = new LinkedList();
        
        queue.add(firstNode);
        visited[sourceX][sourceY] = true;
        
        while(!queue.isEmpty()){
            
            Node current = queue.poll();
            
            //Destination Reached
            if(current.x == targetX && current.y == targetY){
                return current.distance;
            }
            
            //8 Possible moves
            for(int i=0;i<8;i++){
                int x = current.x + dx[i];
                int y = current.y + dy[i];
                int d = current.distance + 1;
                Node node = new Node(x,y,d);
                if(isValid(x,y,N) && !visited[x][y]){
                    queue.add(node);
                    visited[x][y] = true;    
                }               
            }            
        }
     
     //No ans possible
     return -1;   
    }
    
    private boolean isValid(int x, int y, int N){
        return x > -1 && x < N && y > -1 && y < N; 
    }
}
