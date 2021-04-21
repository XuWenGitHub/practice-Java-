package practice.two;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa","a"));
    }
    /*
   s字符串和p字符串能否匹配：s的最后一个字符和p的最后一个字符能否匹配
   如果能匹配：s字符串和p字符串能否匹配==s字符串前(s长度-1）个字符串和p字符串前(p长度-1)个字符串能否匹配
   dp[i][j]表示：s字符串前i个字符和p字符串前j个字符是否能匹配
   dp[0][0]：true
   dp[i][0]：false s字符串有字符，p字符串无字符，肯定不能匹配
   dp[0][i]：判断第i个字符是否为*，如果为*，dp[0][i] = dp[0][i-2]

   dp[i][j]：si表示s字符串第i个字符，pj表示p字符串第j个字符
       si和pj都是小写字符
           si和pj相等：dp[i][j]=dp[i-1][j-1]
           si和pj不相等：dp[i][j]=false;
       pj是'.'
           dp[i][j]=dp[i-1][j-1]
       pj是'*' //（*表示前面0个or多个字符，c*，表示"" or "c" or "cc"...）
           分情况讨论：
               p字符串pj-1个字符==s字符串i个字符 or p字符串pj-1个字符=='.'：
                   dp[i][j]=dp[i-1][j]（*匹配多个前面的那一个元素） or dp[i][j-2]（*匹配0个前面那一个元素）
               p字符串pj-1个字符!=s字符串i个字符：
                   dp[i][j] = dp[i][j-2]
   */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        //s串为空串，p不为空串匹配
        for(int i=1;i<p.length()+1;i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]=dp[0][i-2];
            }
        }
        //判断s串的前i个字符和p串的前j个字符是否能匹配
        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<p.length()+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.'){
                    //当s的第i个字符==p的第i个字符 or p的第i个字符为'.'
                    //那么：s的前i个字符和p的前j个字符是否匹配
                    //就想等于：s的前i-1个字符和p的前j-1和字符是否匹配
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'&&j-2>=0){
                    //如果p的第i个字符为'*'，并且p有第i-1个字符
                    if(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.'){
                        //判断p的第i-1个字符==s的第i个字符 or p的第i-1个字符=='.'
                        //*可以匹配多个前面的那一个元素 or *匹配0个前面那一个元素
                        dp[i][j]=dp[i-1][j]||dp[i][j-2];
                    }else{
                        //反之，*只能匹配0个前面那一个元素
                        dp[i][j]=dp[i][j-2];
                    }
                }else{
                    //其他情况，匹配不了
                    dp[i][j]=false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
