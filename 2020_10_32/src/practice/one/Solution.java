package practice.one;

import java.util.*;

/**
 * @PackgeName: practice.one
 * @ClassName: Solution
 * @Author: XuWen
 * Date: 2020/11/1 16:00
 * Introduce:
 */
class Solution {
    public static void main(String[] args) {
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        List<String> list = topKFrequent(words, 2);
        System.out.println(list);
        System.out.println();
    }

    public static List<String> topKFrequent(String[] words, int k) {
        //构成小顶堆，就保持存储k个即可
        PriorityQueue<Element> queue = new PriorityQueue<>((o1, o2)->{
            int num = o1.nums-o2.nums;
            if(num!=0){
                return num;
            }else{
                return o1.str.compareTo(o2.str);
            }
        });

        Map<String,Integer> strToNum = new HashMap<>();
        for(String str:words){
            if(strToNum.containsKey(str)){
                strToNum.put(str,strToNum.get(str)+1);
            }else{
                strToNum.put(str,1);
            }
        }

        for(Map.Entry<String,Integer> entry:strToNum.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(queue.size()<k){
                queue.add(new Element(key,value));
            }else{
                Element e = queue.peek();
                if(e.nums<value){
                    queue.poll();
                    queue.add(new Element(key,value));
                }
            }
        }
        List<String> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(queue.poll().str);
        }
        return list;



        //     //先把出现单词->个数存入map
        //     Map<String,Integer> map = new HashMap<>();
        //     for(String str:words){
        //         if(map.containsKey(str)){
        //             map.put(str,map.get(str)+1);
        //         }else{
        //             map.put(str,1);
        //         }
        //     }
        //     //定义一个TreeSet，根据先判断单词次数，还有单词次数如果相同的话，就比较单词本身
        //     Set<Element> set = new TreeSet<>((o1,o2)->{
        //         Integer num = o2.nums-o1.nums;
        //         if(num==0){
        //             return o1.str.compareTo(o2.str);
        //         }else{
        //             return num;
        //         }
        //     });
        //     //把map中全添加到TreeSet里面
        //     for(Map.Entry<String,Integer> entry:map.entrySet()){
        //         set.add(new Element(entry.getKey(),entry.getValue()));
        //     }
        //     //把Set中前k个取出来
        //     List<String> res = new ArrayList<>();
        //     int i=1;
        //     for(Element ele:set){
        //         res.add(ele.str);
        //         if(i++==k){
        //             break;
        //         }
        //     }
        //     return res;
    }
    static class Element{
        String str;
        Integer nums;
        public Element(String str,Integer nums){
            this.str = str;
            this.nums = nums;
        }
    }
}
