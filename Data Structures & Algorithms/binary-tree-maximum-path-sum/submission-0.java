class Solution {

    int maxSum;

    public int solve(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int l = solve(root.left);
        int r = solve(root.right);

        int neeche_hi_mil_gya = l + r + root.val;

        int only_ek_best = root.val;

        int koi_ek_accha = Math.max(l, r) + root.val;

        maxSum = Math.max(maxSum,
                Math.max(only_ek_best,
                    Math.max(koi_ek_accha, neeche_hi_mil_gya)));

        return Math.max(only_ek_best, koi_ek_accha);
    }

    public int maxPathSum(TreeNode root) {

        maxSum = Integer.MIN_VALUE;

        solve(root);

        return maxSum;
    }
}