package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/26 9:53
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        TreeNode nodeB = new TreeNode('B');
        TreeNode nodeC = new TreeNode('C');
        TreeNode nodeD = new TreeNode('D');
        TreeNode nodeE = new TreeNode('E');
        TreeNode nodeF = new TreeNode('F');
        TreeNode nodeG = new TreeNode('G');
        TreeNode nodeH = new TreeNode('H');
        TreeNode nodeI = new TreeNode('I');
        TreeNode nodeJ = new TreeNode('J');
        root.left = nodeB;
        root.right = nodeC;
        nodeB.left = nodeD;
        nodeC.left = nodeE;
        nodeC.right = nodeF;
        nodeD.right = nodeG;
        nodeF.left = nodeH;
        nodeF.right = nodeI;
        nodeG.left = nodeJ;
        TreeTraversal.preOrder(root);
        System.out.println();
        TreeTraversal.infixOrder(root);
        System.out.println();
        TreeTraversal.postOrder(root);
    }
}
