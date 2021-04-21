package practice.one;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa","*"));
    }
    //dp[i][j]：表示s前i个字符  和  p前j个字符能否匹配,1代表能匹配，0代表匹配不了
    //考虑最后一步：s的第i个字符si，p的第j个字符pj
    /*
    分情况讨论：
        si和pj都是小写字母
            如果相同：dp[i][j] = dp[i-1][j-1];
            如果不同：dp[i][j] = 0;
        pj是'?'
            dp[i][j] = dp[i-1][j-1];
        pj是'*'
            匹配空字符串（匹配空字符串 or 匹配任意字符串）
            dp[i][j] = dp[i][j-1] or dp[i-1][j]
    这里还需要考虑空串匹配
        dp[0][0] = true;    //空串和空串肯定匹配
        dp[i][0] = false;   //s串有字符，p匹配串空串，肯定匹配不了
        dp[0][i]    //这个要判断p匹配串前i个字符全是*，就是true，不然就是false

    */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=1;i<p.length();i++){
            if(p.charAt(i)=='*'){
                dp[0][i] = true;
            }else{
                break;
            }
        }
        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<p.length()+1;j++){
                if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-1]||dp[i-1][j];
                }else if(p.charAt(j-1)=='?'||(p.charAt(j-1)==s.charAt(i-1))){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
