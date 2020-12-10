package practice.two;
import java.util.Scanner;
import java.util.*;
public class Main{
    public static final int MAX = 100000;
    public static final long MOD = 1000000007L;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long x = sc.nextLong();
            System.out.println(count(x));
        }
    }
    public static long count(long x){
        //这个是保存每次走到的位置和当前位置走了多少步
        Map<Long,Integer> map = new HashMap<>();
        //这个队列来保存走到的位置，然后去广度优先搜索
        Deque<Long> queue = new LinkedList<>();
        map.put(x,0);
        queue.add(x);
        while(!queue.isEmpty()){
            Long poll = queue.poll();
            if(map.get(poll)>MAX){
                break;
            }
            if(poll==0){
                return map.get(poll);
            }
            long d = ((poll<<2)+3)%MOD;
            if(d==0&&(map.get(poll)+1)<=MAX){
                return map.get(poll)+1;
            }
            if(!map.containsKey(d)){
                queue.add(d);
                map.put(d,map.get(poll)+1);
            }
            d = ((poll<<3)+7)%MOD;
            if(d==0&&(map.get(poll)+1)<=MAX){
                return map.get(poll)+1;
            }
            if(!map.containsKey(d)){
                queue.add(d);
                map.put(d,map.get(poll)+1);
            }
        }
        return -1L;
    }
}