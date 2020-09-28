package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/27 18:56
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

//       System.out.println("树的节点个数");
//       System.out.println(TreeTool.sumTreeNode(root));
//       System.out.println(TreeTool.sumTreeNode2(root));
//
//       System.out.println("叶子结点个数");
//       System.out.println(TreeTool.sumLeafNode(root));
//       System.out.println(TreeTool.sumLeafNode2(root));
//       System.out.println(TreeTool.sumLeafNode2(root));
//
//       for(int i=1;i<=6;i++) {
//           System.out.println("第" + i + "层中节点的个数:");
//           System.out.println(TreeTool.sumTreeNodeK(root, i));
//       }

       System.out.println("当前树的高度");
       System.out.println(TreeTool.height(root));

       System.out.println("求二叉树是否包含k");
       System.out.println(TreeTool.contains(null,'a'));
       for(char c = 'A';c<='L';c++) {
           System.out.println("树中包含"+c+":"+TreeTool.contains(root, c));
       }

       System.out.println("在二叉树中找值为k，找到返回该节点，没有找到返回null");
       System.out.println(TreeTool.contains2(null,'a'));
       for(char c = 'A';c<='L';c++) {
           System.out.println("树中包含"+c+":"+TreeTool.contains2(root, c));
       }
   }

}
