package practice.two;

public class Solution {

    public boolean isMatch(String s, String p) {
        return dfs(s.toCharArray(),0,p.toCharArray(),0);
    }

    public static void main(String[] args) {
        System.out.println(num(3));
    }
    //n个节点，返回：多少种不同结构的二叉树
    public static int num(int n){
        return fib(2*n)/(fib(n+1)*fib(n));
    }
    public static int fib(int n){
        if(n==1){
            return 1;
        }
        return fib(n-1)*n;
    }

    //深度优先遍历
    private boolean dfs(char[] s,int i,char[] p,int j){
        //如果遍历完s，同时也遍历完p了，那么就返回true
        if(i==s.length&&j==p.length){
            return true;
        }
        //如果没遍历完s，但是遍历完了p，那么一定是false
        if(i<s.length&&j==p.length){
            return false;
        }
        //如果遍历完s，但是没有遍历完p，那么需要分情况讨论
        if(i==s.length&&j<p.length){
            //判断j+1是否是'*'，如果是，递归继续判断
            if(j+1<p.length&&p[j+1]=='*'){
                return dfs(s,i,p,j+2);
            }else{
                return false;
            }
        }

        //如果s和p都没有遍历完
        //分情况讨论
        if(i<s.length&&j<p.length){
            //先判断j+1位置是否是*
            if(j+1<p.length&&p[j+1]=='*'){
                //如果是*号，再判断目前s[i]是否等于p[j];
                if(s[i]==p[j]||p[j]=='.'){
                    //（1）就是j中*前面的字符出现0次
                    //（2）就是j中*前面的字符出现n次
                    return dfs(s,i,p,j+2)||dfs(s,i+1,p,j);
                }else{
                    //*号前面的出现了0次
                    return dfs(s,i,p,j+2);
                }
            }else{
                //如果不是*号，判断目前s[i]是否等于p[j]
                if(s[i]==p[j]||p[j]=='.'){
                    return dfs(s,i+1,p,j+1);
                }else{
                    return false;
                }
            }
        }
        //前面一定会出结果，这个为了满足方法的返回值
        return false;
    }
}
