package practice.two;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Map<Character,Boolean> map = new LinkedHashMap<>();
        map.put('b',true);
        map.put('a',true);
        map.put('e',false);
        map.put('c',true);
        for(Map.Entry<Character,Boolean> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
    public char firstUniqChar(String s) {
        // if(s.equals("")){
        //     return ' ';
        // }
        int[] chars = new int[26];  //0代表a,1代表b
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            chars[ch-'a']+=1;
        }
        for(int i=0;i<chars.length;i++){
            if(chars[i]==1){
                return (char) ('a'+ i);
            }
        }
        // for(int i=0;i<s.length();i++){
        //     char ch = s.charAt(i);
        //     if(chars[ch-'a']==1){
        //         return ch;
        //     }
        // }
        return ' ';
    }
}