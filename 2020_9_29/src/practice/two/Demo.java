package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/29 19:05
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    //判断一棵树是否为镜像树
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }else{
            return isSymmetric(root.left,root.right);
        }
    }
    public boolean isSymmetric(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        //两个都不为null
        return p.val==q.val&&isSymmetric(p.left,q.right)&&isSymmetric(p.right,q.left);
    }

    //判断两颗树是不是镜像树，就判断根节点左子树右子树
    public static boolean isMirrorTree(TreeNode p,TreeNode q){
        if(p==null&&q==null){   //两棵树都为空
            return true;
        }
        if(p==null||q==null){   //其中一棵树为空
            return false;
        }
        //都不为空，判断根节点&&判断p的左子树和q的右子树相同吗&&p的右子树和q的左子树相同吗？
        return p.val==q.val&&isMirrorTree(p.left,q.right)&&isMirrorTree(p.right,q.left);
    }

    public static TreeNode contains(TreeNode root,TreeNode node){
        if(root==null){
            return null;
        }else{
            if(root==node){
                return root;
            }else {
                TreeNode leftSearch = contains(root.left,node);
                if(leftSearch!=null){
                    return leftSearch;
                }
                return contains(root.right,node);
            }
        }
    }
}
