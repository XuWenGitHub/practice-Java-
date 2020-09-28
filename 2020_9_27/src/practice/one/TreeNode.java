package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: TreeNode
 * @Author: XuWen
 * Date: 2020/9/27 19:03
 * Introduce:
 */
public class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
