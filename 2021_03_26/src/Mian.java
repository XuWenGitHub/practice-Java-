import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mian {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        //ConcurrentHashMap
        String str = "aac1fgac";
        String str1 = "111111111";
        String str2 = "aaaaaaaaa";
//        System.out.println(str);
//        System.out.println(str1);
//        System.out.println(findStrMaxLen(str2));

        String str3 = "It's a soo0o big world!  ";
        String str4 = "                         ";
        String str5 = "BBBBBBBBBBBBBBBBBBBBB";
        System.out.println(findStrMaxLen1(str3));
        System.out.println(findStrMaxLen1(str4));
        System.out.println(findStrMaxLen1(str5));
    }
    public static int findStrMaxLen1(String str){
        String[] split = str.split(" ");
        int res = 0;
        for(String element:split){
            if(checkWord(element)){
                res = Math.max(res,element.length());
            }
        }
        return res;
    }
    public static boolean checkWord(String str){
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if(!check(str.charAt(i))){
                flag = false;
                break;
            }
        }
        return flag;
    }
    //只有字母组成的认为是单词。找最长单词的长度
    //由空格分隔的
    /*
        a a c 1 f g a c
    dp  1 2 3 0 1 2 3 4
     */
    public static int findStrMaxLen(String str){
        char[] chars = str.toCharArray();
        //d[i]，记录包含当前i下标的字符，最长的单词的长度
        int[] dp = new int[chars.length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if(check(ch)){
                //代表是字母
                if(i==0){   //判读当前是否是第一个
                    dp[i] = 1;
                }else{  //当前不是第一个
                    if(dp[i-1]>0){
                        dp[i] = dp[i-1]+1;
                    }else{
                        dp[i] = 1;
                    }
                }
            }else {
                //代表不是字母
                dp[i] = 0;
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }
    public static boolean check(char ch){
        if(ch>='a'&&ch<='z'){
            return true;
        }else{
            return false;
        }
    }
}
