package practice.one;

public class Main {
    public static void main(String[] args) {

    }
    //求一个字符串的最长回文子串
    //第一种中心扩散法
    //以字符串每个字符开始为中心，开始扩散，
    //求出以当前字符为中心，开始扩散的最长回文子串长度
    public static String huiWen(String str){
        char[] chars = str.toCharArray();
        int maxLen = 0; //代表最长回文子串的长度
        int begin = 0;  //这个代表最长回文子串的起始下标
        for(int i=0;i<chars.length;i++){
            int odd = center(chars, i, i);
            int even = center(chars, i, i + 1);
            int curMaxLen = Math.max(odd,even);
            if(curMaxLen>maxLen){
                maxLen = curMaxLen;
                begin = i-(maxLen-1)/2;
            }
        }
        return str.substring(begin,begin+maxLen);
    }
    //分两种情况，如果是回文串长度为奇数，那么left和right相等
    //如果回文串长度为偶数，那么left和right不等
    public static int center(char[] charArray,int left,int right){
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
