class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if(root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        TreeNode prev = null;

        while(!q.isEmpty()) {

            TreeNode curr = q.remove();

            if(curr == null) {

                // level khatam, prev = last node of that level
                ans.add(prev.val);

                if(q.isEmpty()) {
                    break;
                }
                else {
                    q.add(null);
                }

            }
            else {

                prev = curr;

                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return ans;
    }
}