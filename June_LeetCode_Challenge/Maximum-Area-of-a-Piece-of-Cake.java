//Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts where horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.

//Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a huge number, return this modulo 10^9 + 7.

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        
        int rowDiff = Math.max(horizontalCuts[0],h - horizontalCuts[horizontalCuts.length-1]);
        int colDiff = Math.max(verticalCuts[0],w - verticalCuts[verticalCuts.length-1]);
        for(int i =  1 ; i < horizontalCuts.length  ; i++)
        {  
            rowDiff = Math.max(rowDiff,horizontalCuts[i] - horizontalCuts[i-1]);
        }
        for(int j =  1 ; j < verticalCuts.length  ; j++)
        {
            colDiff = Math.max(colDiff,verticalCuts[j] - verticalCuts[j-1]);
        }
    
        
        
        
        
        return (int)((long)rowDiff * colDiff % 1000000007);
        
        
        
        
    }
}
