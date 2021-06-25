// In this problem, a tree is an undirected graph that is connected and has no cycles.

// You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

// Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

class Solution {
    
    class DSU {
    int[] par;
    int[] rank;

    public DSU(int size) {
        par = new int[size];
        for (int i = 0; i < size; i++) par[i] = i;
        rank = new int[size];
    }

    public int find(int x) {
        if (par[x] != x) par[x] = find(par[x]);
        return par[x];
    }

    public boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) {
            return false;
        } else if (rank[xr] < rank[yr]) {
            par[xr] = yr;
        } else if (rank[xr] > rank[yr]) {
            par[yr] = xr;
        } else {
            par[yr] = xr;
            rank[xr]++;
             }
        return true;
    }
}
    
    int MAX_EDGE_VAL = 1000;
    
    public int[] findRedundantConnection(int[][] edges) {
        
        DSU dsu = new DSU(MAX_EDGE_VAL + 1);
        for (int[] edge: edges) {
            if (!dsu.union(edge[0], edge[1])) return edge;
        }
        throw new AssertionError();
        
    }
}
