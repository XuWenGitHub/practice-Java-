package practice.three;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Demo {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abba"));
    }
    public static int lengthOfLongestSubstring2(String s) {
        Map<Character,Integer> map = new HashMap<>();   //存储字符和字符下标+1
        int len=0;  //存储最长子串的长度
        //遍历每个字符串的长度,end-start+1,便是当前无重复字符的s的子串长度
        for(int end=0,start=0;end<s.length();end++){
            char ch=s.charAt(end);
            if(map.containsKey(ch)){
                //表示map的键里面有ch，表示start要变成存储的ch的值了，不然就有重复字符了
                start=Math.max(map.get(ch),start);  //必须要和start比较找大的，不然abba，最后一个a进来的时候，如果不判断谁大，最开始存的a是1，start变成了1，应该让其变成2。
            }
            len=Math.max(len,(end-start+1));
            map.put(ch,end+1);
        }
        return len;
    }

    /*
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();   //存字符 和 字符的下标+1
        int len=0;  //表示这个无重复字符最大的长度
        //start表示无重复字符串的初始下标，end表示结束下标
        for(int end=0,start=0;end<s.length();end++){
            char c = s.charAt(end);   //获取当前下标的字符
            //判断字符是否在map集合的键里存在
            if(map.containsKey(c)){
                //如果存在的话,就要把无重复字符串的start位置换成当前元素的下标，不然下面计算len
                start=Math.max(map.get(c),start);
            }
            len=Math.max((end-start+1),len);    //end-start+1算出了这个字符跟不冲突的字符串的长度为多少
            map.put(s.charAt(end),end+1);   //map集合里存入当前元素和当前元素下标的索引加1
        }
        return len;
    }
}
