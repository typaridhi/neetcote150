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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxval) {

        if(node == null) {
            return 0;
        }

        int cnt = 0;

        if(node.val >= maxval) {
            cnt = 1;
        }

        int newMax = Math.max(maxval, node.val);

        int left = dfs(node.left, newMax);
        int right = dfs(node.right, newMax);

        return cnt + left + right;
    }
}
