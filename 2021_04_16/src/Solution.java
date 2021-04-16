public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(10));
    }
    //长度为n的绳子
    //剪成1段，乘积：n
    //剪成2段，乘积：算出n%2的值，代表剩余，只可能是0或1,然后乘积：((n/2)+1)*(n/2)
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        int res = Integer.MIN_VALUE;
        for(int i=2;i<=n;i++){
            dp[i] = cuttingRope(n,i);
            if(res>dp[i]){
                break;
            }else{
                res = dp[i];
            }
        }
        return res;
    }
    //长度为n的绳子，分成num段
    public int cuttingRope(int n,int num){
        int count = n%num;  //代表余数
        int res = 1;
        for(int i=0;i<num;i++){
            if(count!=0){
                res*=((n/num)+1);
                count--;
            }else{
                res*=((int)(n/num));
            }
        }
        return res;
    }
}