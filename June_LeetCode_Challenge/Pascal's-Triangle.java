class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0 ; i < numRows ; i++)
        {
            List<Integer> l = new ArrayList<>();
            list.add(l);
        }
        
        list.get(0).add(1);
        
        if(numRows==1)
            return list;
        
        list.get(1).add(1);
        list.get(1).add(1);
        
        numRows -= 2;
        
        int idx = 2;
        
        while(numRows > 0 )
        {
            list.get(idx).add(1);
            
            // numofele = idx + 1 // exc 1  => numofele -= 2
            
            int numOfEle = idx + 1 - 2;
            
            for(int i = 1 ; i <= numOfEle ; i++)
            {
                int s = list.get(idx-1).get(i) + list.get(idx-1).get(i-1);
                list.get(idx).add(s);
            }
            
            list.get(idx).add(1);
            
            numRows--;
            
            idx++;
            
            
        }
        
        return list;
        
        
    }
}
