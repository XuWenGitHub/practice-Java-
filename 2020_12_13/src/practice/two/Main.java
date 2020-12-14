package practice.two;

import java.util.*;

public class Main{
    //g和c的两个字母的总的出现次数除以总的字母数目。
    public static void main(String[] args){
        //维护一个滑动窗口
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int num = sc.nextInt();
            System.out.println(method(str,num));
        }
    }
    public static String method(String str,int num){
        Deque<Character> deque = new LinkedList<>();
        int gcNum = 0;
        int maxGcNum = 0;
        int index = 0;
        int i;
        for(i=0;i<str.length();i++){
            if(deque.size()<num){
                deque.addLast(str.charAt(i));
                if(str.charAt(i)=='G'||str.charAt(i)=='C'){
                    gcNum++;
                }
            }else{
                //做判断
                if(gcNum>maxGcNum){
                    maxGcNum = gcNum;
                    index = i-num;
                }
                //相等的时候,i又是新的一个字符了
                char first = deque.removeFirst();
                if(first=='G'||first=='C'){
                    gcNum--;
                }
                deque.addLast(str.charAt(i));
                if(str.charAt(i)=='G'||str.charAt(i)=='C'){
                    gcNum++;
                }
            }
        }
        if(gcNum>maxGcNum){
            maxGcNum = gcNum;
            index = i-num;
        }
        return str.substring(index,index+num);
    }
}
