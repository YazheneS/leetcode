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
class Solution 
{
    public TreeNode sortedArrayToBST(int[] nums) 
    {
       int low =0; int high=nums.length-1;
       return div(nums, low, high);
       
    }
    private TreeNode div(int arr[], int lower, int upper) 
    {  
        if (lower > upper)            
            return null;

        int mid = (lower + upper) / 2;

        TreeNode root = new TreeNode(arr[mid]);   

        root.left = div(arr, lower, mid - 1);     
        root.right = div(arr, mid + 1, upper);    

        return root;
    }
}