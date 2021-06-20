// On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

// Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

// You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?


class Solution {
    
    public class Pair{
        
        int v;
        int i,j;
        
        Pair(int v, int i, int j)
        {
            this.v = v;
            this.i = i;
            this.j = j;
            
        } 
    }
    
    
    
    public int swimInWater(int[][] grid) {
        
        
        int n = grid.length;
        
        boolean[][] vis= new boolean[n][n];
        vis[0][0] = true;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.v - b.v);
        
        int res = grid[0][0];
        pq.add(new Pair(grid[0][0],0,0));
        
        int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
        
       
        while(pq.size()> 0)
        {
            Pair rem = pq.remove();
            
            res = Math.max(res,rem.v);
            
            if(rem.i==n-1 && rem.j==n-1)
                break;
            
            for(int[] dir : dirs)
            {
                int x = rem.i + dir[0];
                int y = rem.j + dir[1];
                
                if(x >= 0 && y >= 0 && x < n && y < n && !vis[x][y])
                {
                    pq.add(new Pair(grid[x][y],x,y));
                    vis[x][y] = true;
                }
            }
            
           
        }
        
        
        return res;
  
        
    }
}
