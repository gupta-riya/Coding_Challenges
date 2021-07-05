// In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

// You are given an m x n matrix mat and two integers r and c representing the row number and column number of the wanted reshaped matrix.

// The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

// If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.


class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        int totalElem = mat.length * mat[0].length;
        
        int targetElem = r * c;
        
        if(totalElem != targetElem)
            return mat;
        
        
        int temp[] = new int[totalElem];
        
        int k = 0; 
        
        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[0].length ; j++)
                temp[k++] = mat[i][j];
        }
        
        
        int res[][] = new int[r][c];
        
        k = 0; 
        
        for(int i =  0 ; i < r ; i++)
        {
            for(int j = 0 ; j < c ; j++)
            {
                res[i][j] = temp[k++];
            }
        }
        
        
       
        return res;
        
        
    }
}
