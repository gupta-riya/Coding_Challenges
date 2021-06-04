// You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

// The lock initially starts at '0000', a string representing the state of the 4 wheels.

// You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

// Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> dead = new HashSet<>();
        
        for (String str : deadends) 
            dead.add(str);
        
        if (dead.contains("0000")) 
            return -1;
        if ("0000".equals(target)) 
            return 0;
        
        Set<String> v = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        que.add("0000");
        
        for (int d = 1; !que.isEmpty(); d++)
        {
            for (int n = que.size(); n > 0; n--)
            {
                String cur = que.poll();
                for (int i = 0; i < 4; i++)
                {
                    for (int dif = 1; dif <= 9; dif += 8)
                    {
                        char[] ca = cur.toCharArray();
                        ca[i] = (char)((ca[i] - '0' + dif) % 10 + '0');
                        String s = new String(ca);
                        if (target.equals(s)) return d;
                        if (!dead.contains(s) && !v.contains(s)) que.add(s);
                        v.add(s);
                    }
                }
            }
        }
        return -1;    
        
    }
}
