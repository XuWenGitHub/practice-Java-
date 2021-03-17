package practice.two;

import java.util.HashMap;
import java.util.Map;

class Solution {
    //最长不重复的子串
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        char[] str = s.toCharArray();
        int max = 1;    //最长不含重复字符的字符串
        int[] dp = new int[str.length]; //dp数组
        dp[0] = 1;  //第一个一定为1
        Map<Character,Integer> map = new HashMap<>();//记录字符->下标，如果后面有重复的，就更新
        map.put(str[0],0);
        for(int i=1;i<str.length;i++){
            if(map.containsKey(str[i])){    //如果出现过了str[i]这个字符
                int preIndex = map.get(str[i]); //获得上一个相同数字的下标
                dp[i] = Math.min(i-preIndex,dp[i-1]+1);
                /*
                获取当前下标-上一次出现该字符的下标值a
                上一个字符，对应的最长不重复字符的字符串+1的值b
                a和b中小的
                Math.min(i-preIndex,dp[i-1]+1);
                解决abba的问题，如果直接写i-preIndex，那么最后一个a，就会是3，包含了两个b
                */
            }else{  //如果还没有出现str[i]这个字符
                dp[i] = dp[i-1]+1;
            }
            map.put(str[i],i);  //更新map
            max = Math.max(max,dp[i]);  //更新max
        }
        return max;
    }
}
