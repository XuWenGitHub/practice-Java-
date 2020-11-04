package practice.three;

/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/11/4 10:59
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
//        System.out.println();
        //System.out.println(isMatch("aa","a"));
    }
    public static boolean isMatch(String s, String p) {
        return dfs(s.toCharArray(),0,p.toCharArray(),0);
    }

    //深度优先遍历
    private static boolean dfs(char[] s,int i,char[] p,int j){
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
    

    //数值的整数次方
    public double myPow(double x, int n) {
        long N = n;
        if(N<0){
            return 1/pow(x,-N);
        }
        return pow(x,N);
    }
    /*
    分治算法
    当n为偶数，(x2)2就可以变成 res = mypow(x,n/2) return res*res;
    当n为基数,x(x2)2既可以变成 res=mypow(x,n/2) return res*res*x;
    */
    public double pow(double x,long n){
        if(x==1){
            return 1;
        }
        if(n==0){
            return 1;
        }

        if((n%2)==0){
            //代表偶数
            double res = pow(x,n/2);
            return res*res;
        }else{
            //代表奇数
            double res = pow(x,(n-1)/2);
            return res*res*x;
        }
    }

//    /*
//    动态规划：
//    */
//    public double myPow(double x,int n,double[] dp){
//        if(n==0){
//            return x;
//        }
//        if(dp[n]>0.0){
//            return dp[n];
//        }
//        dp[n] = myPow(x,n-1,dp)*x;
//        return myPow(x,n-1,dp)*x;
//    }
}
