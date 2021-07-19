// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    
    public ArrayList<TreeNode> path;
    
    public boolean find(TreeNode root,TreeNode node)
    {
        if(root == null)
            return false;
        
        if(node.val == root.val)
        {
            path.add(node);
            return true;
        }
        
        
        if(find(root.left,node))
        {
            path.add(root);
            return true;
        }
        
        if(find(root.right,node))
        {
            path.add(root);
            return true;
        }
            
        return false;
        
    }
    
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        
        path = new ArrayList<>();
        
        find(root,p);
        ArrayList<TreeNode> list1 = path;
        
        path = new ArrayList<>();
        
        find(root,q);
         ArrayList<TreeNode> list2 = path;
        
        int i = list1.size()-1, j=  list2.size()-1;
        
        while(i >= 0 && j>=0 )
        {
            if(list1.get(i)==list2.get(j))
            {
                i--;
                j--;
            }
            else
                break;
        }
        
        return list1.get(i+1);
        
        
        
    }
}
