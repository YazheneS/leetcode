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
    public int sumRootToLeaf(TreeNode root) 
    {
        return traverse(root, "");
    }
    private int traverse (TreeNode root, String binary)
    {
        int sum=0;
        if(root!=null)
        {
            binary+= Integer.toString(root.val);
            sum=traverse(root.left, binary)+traverse(root.right, binary);
            if(root.left==null && root.right==null)
            {
                sum=Integer.parseInt(binary,2);
            }
        }
        return sum;
    }
}