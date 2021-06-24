// There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent four cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

// Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        if (maxMove == 0)
            return 0;
        int[][] curr = new int[m+2][n+2], last = new int[m+2][n+2];
        
        for (int i = 1; i <= m; i++) {
            curr[i][1]++;
            curr[i][n]++;
        }
        
        for (int j = 1; j <= n; j++) {
            curr[1][j]++;
            curr[m][j]++;
        }
        
        int ans = curr[startRow+1][startColumn+1];
        
        for (int d = 1; d < maxMove; d++) {
            int[][] temp = curr;
            curr = last;
            last = temp;
            
            for (int i = 1; i <= m; i++)
                for (int j = 1; j <= n; j++)
                    curr[i][j] = (int)(((long)last[i-1][j] + last[i+1][j] + last[i][j-1] + last[i][j+1]) % 1000000007L);
            ans = (ans + curr[startRow+1][startColumn+1]) % 1000000007;
        }
        return ans;
    }
}
