package practice.five;


public class Main {
    public static void main(String[] args) {
        System.out.println(createTree(6));
    }
    /**
     * n个节点，可以构成多少种不同形态的二叉树
     * 当0个节点的时候，当然只有1种
     * 当1个节点的时候，当然也只有1种
     * 当2个节点的时候，固定一个节点，
     * 左右子树的分布情况为：1+0 0+1，固有f(2)=f(1)*f(0)+f(0)*f(1)=2
     * 当3个节点的时候，固定一个节点，
     * 左右子树的分布情况为：2+0 1+1 0+2，固有f(3)=f(2)*f(0)+f(1)*f(1)+f(0)*f(2)=2+2+1=5
     * 最后递推公式得：(2n)!/((n+1)!*n!)
     */
    public static int createTree(int n){
        return (fact(2*n))/(fact(n+1)*fact(n));
    }
    public static int fact(int n){
        int res = 1;
        for(int i=2;i<=n;i++){
            res*=i;
        }
        return res;
    }
}
