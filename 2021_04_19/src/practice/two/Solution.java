package practice.two;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("()(())"));
    }
    /*
    dp[i]：一定有i个字符，最长的有效长度
    最后一步：
        i个字符为'('，那么肯定没有')'跟其匹配，dp[i]=0
        i个字符为')':
            判断i-1个字符为什么，分情况讨论
            i-1为'(',那么dp[i] = 2+dp[i-2];
            //i和i-1构成一个()+dp[i-2]包含i-2位置字符的最长有效长度
            i-1为')',那么又要分情况讨论
                去判断与i-1位置')'匹配的'('位置的前一个：i-1-dp[i-1]
                i-1-dp[i-1]位置为：'('
                                       还需要判断i-1-dp[i-1]的上一个位置是否是')'
                                       如果是，那么dp[i] = dp[i-1]+2+dp[i-1-dp[i-1]-1]
                                       如果不是，那么dp[i] = dp[i-1]+2
                i-1-dp[i-1]位置为：')'，那么dp[i]=0
    */
    public int longestValidParentheses(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        dp[0]=0;
        int res = 0;
        for(int i=1;i<chars.length;i++){
            if(chars[i]=='('){
                dp[i] = 0;
            }else{  //那么当前字符为')'
                if(chars[i-1]=='('){
                    dp[i] = 2;
                    dp[i]+=((i-2)>=0?dp[i-2]:0);
                }else{  //i-1个位置的字符为')'，去找与其匹配的'('的上一个位置
                    int index = i-1-dp[i-1];
                    if(index>=0&&chars[index]=='('){
                        dp[i] = dp[i-1]+2;
                        //()(())
                        //下面为了去解决上面这种情况
                        //最后一个)的前一个也是),前一个)对应的是倒数第3个(，最后一个)对应的是顺数第3个(
                        //如果不加下面的语句，那么说明，dp[最后一个下标] = 2+dp[倒数第二个下标]
                        //但是前面还可能对应)，所有还需要判断一下
                        if(index-1>=0&&chars[index-1]==')'){
                            dp[i]+=dp[index-1];
                        }
                    }else{  //chars[index]==')'
                        dp[i] = 0;
                    }
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
