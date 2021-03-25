import java.util.LinkedList;
import java.util.List;

public class Demo {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        root.right = node2;
//        node2.left = node3;
//        System.out.println(inorderTraversal(root));

        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node4;
        node1.right = node2;
        System.out.println(kthLargest(root, 1));
    }

    public static int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 0) {
            return root.val;
        }
        int res = kthLargest(root.right, k);
        if (res != 0) {
            return res;
        }

        k--;
        if (k == 0) {
            return root.val;
        }

        res = kthLargest(root.left, k);
        return res;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        List<Integer> l = inorderTraversal(root.left);
        res.addAll(l);
        res.add(root.val);
        List<Integer> r = inorderTraversal(root.right);
        res.addAll(r);
        return res;
    }
}
