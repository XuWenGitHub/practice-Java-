package practice.one;

public class Demo {
    public static void main(String[] args) {
//        String str="1234";
//        System.out.println(str.substring(0,1));
//        System.out.println(str.length());
        int result=10;
        result*=10;
        System.out.println(longestPalindrome2("abcbba"));
        System.out.println(result+'1'-'0');

    }

    /*
    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    示例 1：
    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
    示例 2：
    输入: "cbbd"
    输出: "bb"
    写了一个暴力法，但是时间超了，现在来一个中间往两边扩散自己想的方法
    遍历一个数一遍，从i=1到i=字符串长度-2，然后一个一个遍历，这是判断aba这种回文数的
    遍历一个数一遍，定义两个指针，一直后移，这种判断abba这种回文数的
    */
    public static String longestPalindrome2(String s) {
        if(s.length()==0){
            return "";
        }
        int lenMax=0;  //表示回文数的最长长度
        String str="";
        //判断aba这种回文数的
        for(int i=1;i<s.length();i++){
            int left=i;   //向左蔓延
            int right=i;  //向右蔓延
            while(left-1>=0&&right+1<=s.length()-1&&s.charAt(left-1)==s.charAt(right+1)){
                left-=1;
                right+=1;
            }
            if(right-left+1>lenMax){
                lenMax=right-left+1;
                str=s.substring(left,right+1);
            }
        }

        //这种判断abba这种回文数的
        //p1指向a，p2指向b
        for(int p1=0,p2=p1+1;p1<s.length()-1;p1++,p2++){
            //先要判断p1和p2相等
            if(s.charAt(p1)==s.charAt(p2)){
                int left=p1;    //向左蔓延
                int right=p2;   //向右蔓延
                while(left-1>=0&&right+1<=s.length()-1&&s.charAt(left-1)==s.charAt(right+1)){
                    left-=1;
                    right+=1;
                }
                if(right-left+1>lenMax){
                    lenMax=right-left+1;
                    str=s.substring(left,right+1);
                }
            }
        }

        if(str.equals("")){
            return s.substring(0,1);
        }else{
            return str;
        }
    }


    //寻找一个字符串的最长回文子串
    public static String longestPalindrome(String s) {
        //表示是空串
        if(s.length()==0){
            return "";
        }
        String str = "";    //存最长的回文子串
        int maxLen=0;
        for(int start=0;start<s.length();start++){
            for(int end=start+1;end<s.length();end++){
                if(s.charAt(end)==s.charAt(start)){
                    //表示可能是一个回文子串
                    String ss=s.substring(start,end+1);  //当前可能是回文子串
                    if(ss.equals(reverseStr(ss))){    //判断是不是回文子串
                        int len=end-start+1;    //当前这个回文子串的长度
                        if(len>maxLen){
                            maxLen=len;
                            str=ss;
                            //break;
                        }
                    }
                }
            }
        }
        //如果最后str还是""，那么说明字符串每个字符都是不一样的，随意输出一个即可
        if(str.equals("")){
            return s.substring(0,1);
        }
        return str;
    }
    //字符串逆序
    public static String reverseStr(String str){
        String s="";
        for(int i=str.length()-1;i>=0;i--){
            s+=str.charAt(i);
        }
        return s;
    }
}
