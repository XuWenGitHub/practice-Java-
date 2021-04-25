package practice.one;

class Solution {
    //dp[i]：表示s的前i个字符，能组成不同编码的个数
    //判断最后一个字符的数字是否等于0
    //如果等于0：就只能最后两个字符组成一个数字。
    //如果不等于0，可以最后一个字符组成一个数字，也可以最后两个字符组成一个数字
    //注意：最后两个字符组成一个数字（num>=1&&num<=26）
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0]=1;    //空串，肯定只要一种解码的方式
        for(int i=1;i<dp.length;i++){
            //dp[i]代表s的前i个字符 解码 方法的总数
            //获取前i个字符的最后两个字符组成的数字
            int num = i==1?s.charAt(0)-'0':Integer.parseInt(s.substring(i-2,i));
            //先去处理最后一个字符组成一个数字
            if(num%10!=0){
                dp[i]+=dp[i-1];
            }
            //再去处理最后两个字符组成一个数字
            if(i!=1&&num>=10&&num<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
