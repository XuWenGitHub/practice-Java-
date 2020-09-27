package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: TreeTraversal
 * @Author: XuWen
 * Date: 2020/9/26 11:08
 * Introduce:
 */
public class TreeTraversal {
    //前序遍历
    public static void preOrder(TreeNode root){
        if(root!=null) {
            System.out.print(root.val);
            System.out.print("{");
            preOrder(root.left);
            System.out.print("} {");
            preOrder(root.right);
            System.out.print("}");
        }
    }

    //中序遍历
    public static void infixOrder(TreeNode root){
        if(root!=null){
            System.out.print("{");
            infixOrder(root.left);
            System.out.print("}");
            System.out.print(root.val);
            System.out.print("{");
            infixOrder(root.right);
            System.out.print("}");
        }
    }

    //后序遍历
    public static void postOrder(TreeNode root){
        if(root!=null){
            System.out.print("{ ");
            postOrder(root.left);
            System.out.print(" } { ");
            postOrder(root.right);
            System.out.print(" } ");
            System.out.print(root.val);
        }
    }
}
