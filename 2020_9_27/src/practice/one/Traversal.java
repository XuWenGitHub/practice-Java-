package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: Traversal
 * @Author: XuWen
 * Date: 2020/9/27 19:04
 * Introduce:
 */
public class Traversal {
    public static void preOrder(TreeNode root){
        if(root!=null){
            System.out.printf("%c",root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void infixOrder(TreeNode root){
        if(root!=null){
            System.out.printf("%c",root.val);
            infixOrder(root.left);
            infixOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root){
        if(root!=null){
            System.out.printf("%c",root.val);
            postOrder(root.left);
            postOrder(root.right);
        }
    }
}
