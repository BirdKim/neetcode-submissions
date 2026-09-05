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
    public int diameterOfBinaryTree(TreeNode root) {
        // initialize array object of size 1
        int[] res = new int[1];
        // call helper method
        dfs(root, res);
        return res[0];
    }

    public int dfs(TreeNode root, int[] res) {
        if (root == null) return 0;
        // gets the max depth of each side of the node
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        // updates the res; in case other length is greater than left+right
        res[0] = Math.max(res[0], left+right);
        // return max depth of tree starting from the current node 
        return 1 + Math.max(left, right);
    }
}
