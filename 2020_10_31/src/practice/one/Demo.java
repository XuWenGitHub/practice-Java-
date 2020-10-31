package practice.one;

import java.util.*;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/31 20:58
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){

        }
        String s = "Bob hit a ball, the hit BALL flew far after it was hit".toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        sb.append('2');
        System.out.println(sb.toString());
        System.out.println(s);
        char a = 'D'+32;
        sb = new StringBuilder();
        System.out.println(sb.toString().equals(""));
        System.out.println(a);

        System.out.println('a'^'a');
    }
    //找不同
    public char findTheDifference(String s, String t) {
        char res = t.charAt(t.length()-1);
        //直接异或即可
        for(int i=0;i<s.length();i++){
            res^=s.charAt(i);
            res^=t.charAt(i);
        }
        return res;
    }

    /*
    最常见的单词
    先将paragraph中每个单词取出来
    然后造一个set，遍历banned，存入set
    造一个map，遍历第一步取出来的每个单词，然后存每个单词但不包括set里面的单词->个数
    遍历map找出个数最多的单词，返回
    */
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> list= getSplit(paragraph);
        Map<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(String s:banned){
            set.add(s);
        }
        for(String s:list){
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }
        String res=null;
        Integer max=0;
        for(Map.Entry<String,Integer> enrty:map.entrySet()){
            Integer value = enrty.getValue();
            String key = enrty.getKey();
            if(value>max&&!set.contains(key)){
                max = value;
                res = key;
            }
        }
        return res;
    }
    public List<String> getSplit(String str){
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='A'&&ch<='Z'){
                ch+=32;
                sb.append(ch);
            }else if(ch>='a'&&ch<='z'){
                sb.append(ch);
            }else{
                if(!sb.toString().equals("")){
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        if(!sb.toString().equals("")){
            list.add(sb.toString());
        }
        return list;
    }
}
