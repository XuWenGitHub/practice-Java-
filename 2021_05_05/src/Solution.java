class Solution {
    /*
    dp[i][j] = s1的前i个字符和s2的前j个字符，是否能拼凑s3的前i+j个字符
    初始化：
    dp[0][0] = true //两个空串，肯定能拼凑一个空串
    dp[i][0] = dp[i-1][0]&&s1的第i个字符，是否相等
    dp[0][j] = dp[0][j-1]&&s2的第j个字符，是否相等

    动态转移方程
    dp[i][j] = s1的前i个字符和s2的前j个字符，是否能拼凑s3的前i+j个字符
        分情况：
            s1的第i个字符和s3的第i+j个字符相等
                dp[i][j] = dp[i-1][j];
            s2的第j个字符和s3的第i+j个字符相等
                dp[i][j] = dp[i][j-1];
            都不相等
                dp[i][j] = false
    */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        //初始化
        dp[0][0] = true;
        for(int i=1;i<=s1.length();i++){
            if(dp[i-1][0]&&s1.charAt(i-1)==s3.charAt(i-1)){
                dp[i][0] = true;
            }else{
                break;
            }
        }
        for(int j=1;j<=s2.length();j++){
            if(dp[0][j-1]&&s2.charAt(j-1)==s3.charAt(j-1)){
                dp[0][j] = true;
            }else{
                break;
            }
        }
        //根据转移方程设置dp数组
        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                //分情况讨论
                if(s1.charAt(i-1)==s3.charAt(i+j-1)){
                    dp[i][j] = dp[i-1][j];
                }
                if(!dp[i][j]&&s2.charAt(j-1)==(s3.charAt(i+j-1))){
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}