package practice.four;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str = "ABCDABD";
        System.out.println(Arrays.toString(kmpNext(str)));
    }


    //先算出字符串匹配表
    public static int[] kmpNext(String str){
        int[] next = new int[str.length()];
        next[0] = 0;
        for(int i=1,j=0;i<str.length();i++){
            while(j>0&&str.charAt(i)!=str.charAt(j)){
                j = next[j-1];
            }
            if(str.charAt(i)==str.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
