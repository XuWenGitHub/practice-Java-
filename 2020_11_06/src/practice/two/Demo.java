package practice.two;

import java.util.*;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/11/6 21:41
 * Introduce:
 */
public class Demo {
    static class Employee{
        int id;
        int importance;
        public List<Integer> subordinates;
    }

    public static void main(String[] args) {
//        HashSet
        System.out.println(isIsomorphic("egg","add"));
    }

    //查询子员工的所有重要值
    public int getImportance(List<Employee> employees, int id) {
        if(employees==null||employees.size()==0){
            return 0;
        }
        //因为id不会重复,我们用个map<Integer,Employee>,就可以直接通过id查找员工
        //不然还要通过employee去找id，太慢了
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee employee:employees){
            map.put(employee.id,employee);
        }
        //我们通过广度优先遍历，来算出res，因为这个就可以看成一个图or树
        int res=0;
        Queue<Integer> queue = new LinkedList<>();  //这个队列来帮助广度优先遍历，存员工id
        queue.offer(id);
        while(!queue.isEmpty()){
            Employee employee = map.get(queue.poll());
            res+=employee.importance;   //添加重要值
            //添加当前员工的下属员工id
            for(Integer subordinate:employee.subordinates){
                queue.offer(subordinate);
            }
        }
        return res;
    }

    //字符串中的第一个唯一字符
    //把每一个字符->出现次数，存成映射关系
    //最后遍历s，然后再map里面找value，如果等于1，就直接返回下标
    public int firstUniqChar(String s) {
        //用数组来记录26个英文字母出现的次数
        //a->0,b->1下标
        int[] result = new int[26];
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (result[s.charAt(i) -'a'] == 1) {
                return i;
            }
        }
        return -1;

        // Map<Character,Integer> charToNum = new HashMap<>();
        // for(int i=0;i<s.length();i++){
        //     char ch = s.charAt(i);
        //     if(charToNum.containsKey(ch)){
        //         charToNum.put(ch,charToNum.get(ch)+1);
        //     }else{
        //         charToNum.put(ch,1);
        //     }
        // }

        // for(int i=0;i<s.length();i++){
        //     if(charToNum.get(s.charAt(i))==1){
        //         return i;
        //     }
        // }
        // return -1;



    }

    //判断两个字符串是否是一种类型
    public static boolean isIsomorphic(String s, String t) {
        //AABAA类型和AABAA类型
        //判断，只修要判断每个字符在字符串第一次出现的下标是否相同，如果不相同就不是相同类型，如果都相同，那么就是同一类型
        if(s.length()!=t.length()){
            return false;
        }
        char[] scharArr = s.toCharArray();
        char[] tcharArr = t.toCharArray();

        for(int i=0;i<scharArr.length;i++){
            if(s.indexOf(scharArr[i])!=t.indexOf(tcharArr[i])){
                return false;
            }
        }
        return true;

        // if(s.length()!=t.length()){
        //     return false;
        // }
        // //1，来个res保存例如egg=122 add=122
        // int sres = 0;
        // int snum = 0;
        // Map<Character,Integer> sChartoVal = new HashMap<>();

        // int tres = 0;
        // int tnum = 0;
        // //表示每个字符表示的几
        // Map<Character,Integer> tChartoVal = new HashMap<>();
        // for(int i=0;i<s.length();i++){
        //     char sch = s.charAt(i);
        //     char tch = t.charAt(i);

        //     if(sChartoVal.containsKey(sch)){
        //         sres*=10;
        //         sres+=sChartoVal.get(sch);
        //     }else{
        //         snum+=1;
        //         sres*=10;
        //         sres+=snum;
        //         sChartoVal.put(sch,snum);
        //     }

        //     if(tChartoVal.containsKey(tch)){
        //         tres*=10;
        //         tres+=tChartoVal.get(tch);
        //     }else{
        //         tnum+=1;
        //         tres*=10;
        //         tres+=tnum;
        //         tChartoVal.put(tch,tnum);
        //     }
        // }
        // return sres==tres;
    }


}
