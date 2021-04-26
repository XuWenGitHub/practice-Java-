import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String str = "nowcode";
        HashSet<String> dict = new HashSet<>();
        dict.add("now");
        dict.add("code");
        System.out.println(wordBreak(str,dict));
    }

    /**
     * 字符串分割
     * @param str 字符串
     * @param dict  字典中的单词
     * @return 字符串是否是，字典中的单词拼凑的句子
     */
    public static boolean wordBreak(String str, HashSet<String> dict) {
        //dp[i]表示前i+1个字符是否能组成单词
        boolean[] dp = new boolean[str.length()];
        for (int i = 0; i < str.length(); i++) {
            //先分割[0,i+1)字符串，判断其是否是单词，如果不是，那么是多个单词
            if (dict.contains(str.substring(0, i + 1))) {
                dp[i] = true;
            } else {
                for (int j = 0; j < i; j++) {   //判断dp[j]是否为true
                    //判断dp[j]为true,表示前j+1个字符已经组成单词了
                    //只需要后[j+1,i+1)能组成单词
                    if (dp[j]&&dict.contains(str.substring(j+1,i+1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[str.length()-1];
    }
}
