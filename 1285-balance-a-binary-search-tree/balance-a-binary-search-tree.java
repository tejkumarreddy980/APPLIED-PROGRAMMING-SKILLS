class Solution {
    List<TreeNode> nodes = new ArrayList<TreeNode>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return buildTree(0, nodes.size() - 1);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        nodes.add(root);
        inorder(root.right);
    }

    private TreeNode buildTree(int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = nodes.get(mid);

        root.left = buildTree(start, mid - 1);
        root.right = buildTree(mid + 1, end);

        return root;
    }
}
