// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.


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
    
    
    public int preIndex = 0;
    
    public TreeNode helperBuildTree(int[] preorder, int[] inorder, int start, int end,HashMap<Integer,Integer>hm)
    {
        if(start > end)
            return null;
        
        int nodeVal = preorder[preIndex++];
        
        TreeNode newNode = new TreeNode(nodeVal);
        
        if(start==end)
            return newNode;
        
        int ind = hm.get(nodeVal);
        
        newNode.left = helperBuildTree(preorder,inorder,start,ind-1,hm);
        newNode.right = helperBuildTree(preorder,inorder,ind+1,end,hm);
        
        return newNode;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i  = 0 ; i < inorder.length ; i++)
            hm.put(inorder[i], i);
        
        
        return helperBuildTree(preorder,inorder,0,inorder.length-1,hm);
        
        
        
        
        
    }
}
