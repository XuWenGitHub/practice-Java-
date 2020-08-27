package cn.itcast_05;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/*
* "aababcabcdabcde",获取字符串中每一个字母出现的次数要求结果：
* 输出:
*       "a(5)b(4)c(3)d(2)e(1)"
*
* 思路1：定义26个统计变量即可。遍历字符串，得到每一个字符进行判断，
* 对应的统计变量++即可，最后拼接的输出结果。
*
* 思路2：
*       A：定义一个字符串   可以改为键盘录入字符串
*       B：定义一个Map集合
*       C：把字符串转换为字符数组
*       D：遍历字符数组，得到每一个字符
*       E：拿这个字符到Map集合中去找，看返回值
*               是null：就把该字符作为键，1做为值存储
*               不是null：就把值++，然后重新存储该1键和值
*       F：定义一个字符串缓冲区
*       G：遍历TreeMap集合，获取每一个键值对元素拼接
*       H：把字符串缓冲区转换为字符串输出
* */
public class TreeMapDemo {
    public static void main(String[] args) {
        /*//定义一个字符串
        String s = "aababcabcdabcde";*/
        System.out.print("请输入一个字符串：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(s);

        //定义一个Map集合
        TreeMap<Character,Integer> tm = new TreeMap<Character, Integer>();

        //把字符串转换为字符数组
        char[] array = s.toCharArray();

        //遍历字符数组，得到每一个字符
        for(char ch:array){
//          //拿刚才得到的字符作为键到集合中去找值，看返回值
            Integer i = tm.get(ch);

            //拿这个字符到Map集合中去找，看返回值
            if(i==null){
                //是null：就把该字符作为键，1做为值存储
                tm.put(ch,1);
            }else {
                //不是null：就把值++，然后重新存储该1键和值
                i++;
                tm.put(ch,i);
            }
        }

        //定义一个字符串缓冲区
        StringBuilder sb = new StringBuilder();

        //遍历TreeMap集合，获取每一个键值对元素拼接
        Set<Character> set = tm.keySet();
        for(Character key:set){
            Integer value = tm.get(key);
            sb.append(key).append("(").append(value).append(")").append(" ");
        }

        //把字符串缓冲区转换为字符串输出

        //第一种方法
        /*System.out.println(String.valueOf(sb));*/

        //第二种方法
        String result = sb.toString();
        System.out.println("每个字符和其对应的个数为："+result);
    }
}
