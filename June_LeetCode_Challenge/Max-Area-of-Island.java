//You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

//The area of an island is the number of cells with a value 1 in the island.

//Return the maximum area of an island in grid. If there is no island, return 0.


class Solution {
    
    public void getIsland(int[][]grid,int sr,int sc,ArrayList<Integer> comp,boolean[][]visited)
    {
        if(sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length || visited[sr][sc]==true || grid[sr][sc]==0)
            return;
        
        
        visited[sr][sc] = true;
        comp.add(1);
        
        getIsland(grid,sr,sc-1,comp,visited);
        getIsland(grid,sr-1,sc,comp,visited);
        getIsland(grid,sr,sc+1,comp,visited);
        getIsland(grid,sr+1,sc,comp,visited);
        
    }
    
    
    
    public int maxAreaOfIsland(int[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j]!=0 && visited[i][j] == false)
                {
                    ArrayList<Integer> comp = new ArrayList<>();
                   
                    getIsland(grid,i,j,comp,visited);
                    
                    max = Math.max(comp.size(),max);
                }
            }
        }
        
        return max;
        
    }
}
