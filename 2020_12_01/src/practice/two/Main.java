package practice.two;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();    //代表当前数组的个数
            List<Integer> list = new LinkedList<>();
            for(int i=0;i<n;i++){
                list.add(i);
            }
            System.out.println(method(list));
        }
    }
    public static int method(List<Integer> list){
        int index = 0;
        int count=0;
        while(list.size()!=1){
            if(index==list.size()){
                index=0;
            }
            if(count==2){
                list.remove((Integer)(list.get(index)));
                count=0;
                continue;
            }
            count++;
            index++;
        }
        return list.get(0);
    }
}
