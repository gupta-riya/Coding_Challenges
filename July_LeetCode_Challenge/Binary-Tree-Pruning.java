// Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

// A subtree of a node node is node plus every node that is a descendant of node.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public class Prune{
        
        TreeNode node = null;
        int sub = 0;
        
    }
  
    public Prune getPruning(TreeNode root)
    {
        if(root == null)
        {
            return new Prune();
        }
        
        Prune left = getPruning(root.left);
        Prune right = getPruning(root.right);
        
        Prune nprune = new Prune();
        
        if(root.val == 1 || left.sub==1 || right.sub == 1)
            nprune.sub = 1;
        
        if(left.sub == 0)
            root.left = null;
        
        if(right.sub == 0)
            root.right = null;
        
        if(nprune.sub == 1)
            nprune.node = root;
       
        return nprune;
        
        
    }
    
    
    
    
    public TreeNode pruneTree(TreeNode root) {
        
        
        Prune pr = getPruning(root);
        if(pr.sub == 1)
            return pr.node;
        else
            return null;
        
        
        
        
    }
}
