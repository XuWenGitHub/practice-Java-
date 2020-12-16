import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(restoreIpAddresses(s));
        }
    }

    //0,255每个值,最多能分成4段,每一段的值>=0  <=255
    //用递归回溯去写
    public static ArrayList<String> res = new ArrayList<String>();
    public static ArrayList<String> restoreIpAddresses(String s) {
        method(s,0,1,new StringBuilder());
        return res;
    }
    //inner代表传入过来，可用的数，index代表当前用到index下标的数,num代表当前第几段
    public static void method(String inner,int index,int num,StringBuilder sb){
        if(num==5&&index==inner.length()){
            res.add(sb.toString());
        }
        if(inner.length()<5-num||index>=inner.length()||num==5){
            String[] split = sb.toString().split(".");
            sb = new StringBuilder();
            for(int i=0;i<split.length-1;i++) {
                sb.append(split[i]).append(".");
            }
            return;    //表示已经不够用了
        }
        for(int i=1;i<=3;i++){
            if(i+index<=inner.length()){
                String substr = inner.substring(index,i+index);
                int val = Integer.parseInt(substr);
                if(val>=0&&val<=255){
                    sb.append(substr);
                    if(num!=4){
                        sb.append(".");
                    }
                    method(inner,i+index,num+1,sb);
                }
            }
        }
    }
}