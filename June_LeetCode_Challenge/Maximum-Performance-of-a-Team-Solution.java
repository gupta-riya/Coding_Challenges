// You are given two integers n and k and two integer arrays speed and efficiency both of length n. There are n engineers numbered from 1 to n. speed[i] and efficiency[i] represent the speed and efficiency of the ith engineer respectively.

// Choose at most k different engineers out of the n engineers to form a team with the maximum performance.

// The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.

// Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 10^9 + 7.

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int[][] comb = new int[n][2];
        
        for (int i = 0; i < n; i++)
            comb[i] = new int[] {efficiency[i], speed[i]};
        
        //sorting with comparator
        Arrays.sort(comb, (a, b) -> Integer.compare(b[0], a[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        long ts = 0, max = 0;
        
        
        for (int[] pair : comb) {
            int spd = pair[1];
            pq.add(spd);
            if (pq.size() <= k)
                ts += spd;
            else 
                ts += spd - pq.poll();
            max = Math.max(max, ts * pair[0]);
        }
        return (int)(max % 1000000007);
        
    }
}
