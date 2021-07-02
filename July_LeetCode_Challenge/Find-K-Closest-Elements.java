class Solution {
    
   public class Pair implements Comparable<Pair>{
       
       int val;
       int gap;
       
       Pair(int val,int gap)
       {
           this.val = val;
           this.gap = gap;
       }
       
       public int compareTo(Pair o)
       {
           if(this.gap > o.gap)
               return 1;
           else if(this.gap==o.gap)
           {
               return this.val - o.val;
           }
           else
               return -1;
          
       }
       
       
   }
    
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        
        PriorityQueue<Pair> que = new PriorityQueue<>();
        
        for(int i = 0 ; i < arr.length ; i++)
        {
            que.add(new Pair(arr[i],Math.abs(arr[i]-x)));
        }
        
        PriorityQueue<Integer> res = new PriorityQueue<>();
        
        int t = k;
        
        while(t > 0)
        {
            res.add(que.poll().val);
            t--;
        }
        
        
        List<Integer> list = new ArrayList<>();
        
        while(res.size() > 0)
        {
            list.add(res.poll());
        }
        
        
        return list;
        
        
        
    }
}
