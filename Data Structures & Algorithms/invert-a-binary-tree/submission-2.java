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
    public TreeNode invertTree(TreeNode root) {
        // What is needed to be done
        // What are the requirements
        // from the root node, we need to flip the left node and the right node
            // in order to do this we use a temp variable
        // we can recursively do so by inputting the left and right node into the function again
        
        // edge case of when root is null –– needed because the leaf nodes will result in an error
        // when no child nodes are found
        if (root == null) return null;
        // declare and initialize tmp TreeNode
        TreeNode tmp = root.left;
        // flip the left and right nodes
        root.left = root.right;
        root.right = tmp;
        // recursively call the function again with the left and right node as the parameters
        this.invertTree(root.left);
        this.invertTree(root.right);
        
        return root;
    }
}
