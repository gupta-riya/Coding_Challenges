// Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.

// Return the minimum size of the set so that at least half of the integers of the array are removed.

 class Solution {
    public int minSetSize(int[] arr) {
        
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i =  0 ; i < arr.length ; i++)
        {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{return b - a;});
        
        
        for(Integer i : hm.keySet())
        {
            pq.add(hm.get(i));
        }
        
        int n = 0;
        int total = arr.length;
        int min = total/2;
        int sum = 0;
        
        while(sum < min)
        {
            sum += pq.remove();
            n++;
        }
        
        return n;
        
        
        
        
    }
}
