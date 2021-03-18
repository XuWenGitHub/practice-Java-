package practice.one;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static final int COUNT=4;
    int[] ip = null;
    List<String> res = null;
    public List<String> restoreIpAddresses(String s) {
        ip = new int[COUNT];
        res = new ArrayList<>();
        dfs(s,0,0);
        return res;
    }
    //s代表字符串，index代表s的下标，num代表第几个ip
    public void dfs(String s,int index,int num){
        if(num==COUNT){ //当凑够ipv4后
            if(index==s.length()){  //并且字符串的数字用完了
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<ip.length;i++){
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

        if(s.charAt(index)=='0'){
            ip[num] = 0;
            dfs(s,index+1,num+1);
            return; //这里要return
        }

        int addr = 0;   //这个变量用来回溯
        //i代表当前String的第i个字母
        for(int i=index;i<s.length();i++){  //这个用来递归当前num位置的
            addr = addr*10+(s.charAt(i)-'0');
            if(addr>=0&&addr<=255){
                ip[num] = addr;
                dfs(s,i+1,num+1);
            }else{
                break;
            }
        }
    }

}
