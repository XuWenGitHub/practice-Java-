package practice.one;

import java.util.ArrayList;
import java.util.List;

//输入一个字符串
public class Solution {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println('1'-'0');
    }
    static final int COUNT=4;   //这个代表ipv4的个数
    static int[] ip = null; //这个代表每次存储的ipv4的数
    static List<String> res = null; //这个存储每次可以组成的组合
    public static List<String> restoreIpAddresses(String s) {
        ip = new int[COUNT];
        res = new ArrayList<>();
        dfs(s,0,0);
        return res;
    }
    //s代表字符串，index代表遍历s中的数字下标，num代表第几个ip
    public static void dfs(String s,int index,int num){
        if(num==COUNT){ //当凑够ipv4后
            if(index==s.length()){  //并且字符串的数字用完了
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<COUNT;i++){
                    sb.append(ip[i]);
                    if(i!=ip.length-1){
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }
            return;
        }

        if(index==s.length()){  //ip没有凑够，但是字符串中的字符用完了
            return;
        }

        if(s.charAt(index)=='0'){   //代表当前字符是0，就只能一个0独占一个ip的位置
            ip[num] = 0;
            dfs(s,index+1,num+1);
            return;
        }

        int addr = 0;   //这个变量用来回溯，记录上一次的ip中num段的数字
        //i代表从当前index位置开始，
        for(int i=index;i<s.length();i++){
            addr = addr*10+(s.charAt(i)-'0');
            if(addr>=0&&addr<=255){
                ip[num] = addr;
                //递归处理下一段ip的num位置
                dfs(s,i+1,num+1);
            }else{
                break;
            }
        }
    }
}
