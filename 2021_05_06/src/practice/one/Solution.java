package practice.one;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome2("babad"));
    }
    /*
    dp[i][j]：表示s字符串的区间 [i,j] 是否为回文串
    初始化：
    j>=j
    dp[i][j]&&i==j：true 长度为1的字符串一定是回文串
    dp[i][j]&&j-i==1：判断s字符串的第i个字符和第j个字符是否相等，长度为2的字符串
    动态转移方程：
        dp[i][j]==true&&第i-1个字符和第j+1个字符相等，那么dp[i-1][j+1]=true
            反之dp[i-1][j+1]=false


    */
    public String longestPalindrome2(String s) {
        if(s==null||s.length()<=1){
            return s;
        }
        int maxLen = 1;
        int left = 0;
        int right = 0;
        //dp[i][j]：表示s字符串的[i,j]是否为回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        //初始化长度为1的字符串一定为回文串
        for(int i=0;i<dp.length;i++){
            dp[i][i] = true;
        }
        //初始化长度为2的子串是否为回文串
        for(int l=0,r=1;r<s.length();l++,r++){
            if(s.charAt(l)==s.charAt(r)){
                dp[l][r] = true;
                left = l;
                right = r;
                maxLen = 2;
            }
        }
        //根据状态转移方程去完善dp数组
        for(int i=0;i<s.length()-1;i++){
            for(int j=i;j<=i+1;j++){
                //根据每一行的i==j和其下一个位置开始设置回文串
                if(dp[i][j]){   //如果当前字符串s的[i,j]为回文串
                    int leftIndex = i-1;
                    int rightIndex = j+1;
                    while(leftIndex>=0&&rightIndex<s.length()){
                        if(s.charAt(leftIndex)==s.charAt(rightIndex)){
                            dp[i][j] = true;
                            //说明根据当前dp[i][j]推理dp[i-1][j+1]为回文串
                            if(maxLen<rightIndex-left+1){   //判断是否比当前最长回文串长
                                maxLen = rightIndex-left+1;
                                left = leftIndex;
                                right = rightIndex;
                            }
                            leftIndex--;
                            rightIndex++;
                        }else{
                            break;
                        }
                    }
                }
            }
        }

        return s.substring(left,right+1);
    }

    //中心扩散法
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int maxLen = 0; //代表最长回文子串的长度
        int begin = 0;  //这个代表最长回文子串的起始下标
        for(int i=0;i<chars.length;i++){
            //遍历字符串每个字符，求包含每个字符的最长回文子串
            //包含每个字符的最长回文子串
            //=max(包含该字符的奇数最长回文子串,包含该字符的偶数最长回文子串)
            int odd = center(chars, i, i);
            int even = center(chars, i, i + 1);
            int curMaxLen = Math.max(odd,even);
            if(curMaxLen>maxLen){
                maxLen = curMaxLen;
                begin = i-(maxLen-1)/2;
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    //分两种情况，如果是回文串长度为奇数，那么left和right相等
    //如果回文串长度为偶数，那么left和right不等
    public int center(char[] charArray,int left,int right){
        int len = charArray.length;
        int l = left;
        int r = right;
        while(l>=0&&r<len){
            if(charArray[l]==charArray[r]){
                l--;
                r++;
            }else{
                break;
            }
        }
        return r-l-1;   //这表示当前回文串的长度
    }
}
