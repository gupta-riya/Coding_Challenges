// Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

// Note that it is the kth smallest element in the sorted order, not the kth distinct element.


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        
       
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{return b-a;});
        
            
        for(int i = 0 ; i < r ; i++)
        {
            for(int j = 0 ; j < c ; j++)
            {
               
                    if(pq.size() < k)
                       pq.add(matrix[i][j]);
                    else
                    {
                        if(matrix[i][j] < pq.peek())
                        {
                            pq.remove();
                            pq.add(matrix[i][j]);
                        }
                    }
                    
                   
                
            }
        }
        
        
        return pq.peek();
        
        
        
        
    }
}
