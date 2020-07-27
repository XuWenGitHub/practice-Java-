package practice.two;

public class Demo {
    public static void main(String[] args) {
        System.out.println(isSubsequence("aaaaaa","bbaaaa"));
    }
    /*
    给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
示例 1:
s = "abc", t = "ahbgdc"
返回 true.
示例 2:
s = "axc", t = "ahbgdc"
返回 false.
     */
    /*
    定义一个数组来存储t中找到s字符串的每个字符的下标，下次遍历从数组最后一个有效长度遍历
    */
    public static boolean isSubsequence(String s, String t) {
        int[] arr = new int[s.length()];    //在t中存s每一个字符的下标
        int index=-1;
        for(int i=0;i<s.length();i++){
            char findS=s.charAt(i); //表示s的字符
            boolean flag=false; //表示是否找到

            for(int j=index==-1?0:arr[index]+1;j<t.length();j++){
                if(t.charAt(j)==findS){
                    index++;
                    flag=true;
                    arr[index]=j;   //把下标存入数组
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }
}
