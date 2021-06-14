// You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

// numberOfBoxesi is the number of boxes of type i.
// numberOfUnitsPerBoxi is the number of units in each box of the type i.
// You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

// Return the maximum total number of units that can be put on the truck.


class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        
        // sort the array on the basis of units per box
        
        Arrays.sort(boxTypes,new Comparator<int[]>(){
            
            public int compare(int[]first,int[]second)
            {
                if(first[1] <= second[1])
                    return 1;
                else
                    return -1;
            }
            
            
            
        });
        
        
      
            
        int cap = truckSize;
        
        int i = 0, units = 0;
        
        while(cap > 0 && i<boxTypes.length)
        {
           if(cap >= boxTypes[i][0])
           {
               cap -= boxTypes[i][0];
               units += boxTypes[i][0]*boxTypes[i][1];
           }
           else
           {
               units += cap*boxTypes[i][1];
               cap = 0;
               
           }
           
            i++;
        }
        
        
        
        
       
        return units;
        
        
        
    }
}
