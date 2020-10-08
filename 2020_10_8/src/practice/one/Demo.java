package practice.one;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/8 21:34
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    //二叉搜索树的两个节点的最近公共祖先，方法1
    //先把p和q的路径保存到List里面
    //然后一个一个找，两个指定界定的最近公共祖先，一定在p和q两个路径中不一样的前一个相同的
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //获取p的路径
        List<TreeNode> pathP = getPath(root,p);
        //获取q的路径
        List<TreeNode> pathQ = getPath(root,q);
        //保存最近公共祖先
        TreeNode res = null;
        for(int i=0;i<pathP.size()&&i<pathQ.size();i++){
            if(pathP.get(i)==pathQ.get(i)){
                res = pathQ.get(i);
            }else{
                break;
            }
        }
        return res;
    }
    public List<TreeNode> getPath(TreeNode root,TreeNode p){
        List<TreeNode> list = new ArrayList<>();
        while(root!=p){
            list.add(root);
            if(root.val<p.val){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        list.add(root); //要把自身也要保存到
        return list;
    }

    //二叉搜索树的两个节点的最近公共祖先，方法2
    //如果两个节点的公共祖先，那么一定是在他们公共祖先的左子树和右子树
    //当root.val小于p.val&&root.val小于q.val,那么root往右走
    //当root.val大于p.val&&root.val大于q.val,那么root往左走
    //当其他情况，那么就返回
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = null;
        while(true){
            res=root;
            if(root.val<p.val&&root.val<q.val){
                root = root.right;
            }else if(root.val>p.val&&root.val>q.val){
                root = root.left;
            }else{
                break;
            }
        }
        return res;
    }
}
