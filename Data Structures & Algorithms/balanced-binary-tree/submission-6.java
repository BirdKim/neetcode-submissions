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

    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode root) {
        // creates base case
        if (root == null) {
            return new int[]{1, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        // if both left and right side are true, and
        // the two subtrees have a difference in height of max 1,
        // set balanced to true
        // false other wise
        boolean balanced = (left[0] == 1 && right[0] == 1) &&
                            (Math.abs(left[1] - right[1]) <= 1);
        // gets the depth of the tree from the current node
        int height = 1 + Math.max(left[1], right[1]);
        // Conditional return statement
        // if balanced is true, 1 if not 0 and height as first and second elements in int[]
        return new int[]{balanced ? 1 : 0, height};
    }
}