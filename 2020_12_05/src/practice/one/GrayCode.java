package practice.one;

import java.util.*;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getGray(2)));
    }
    //0,1
    //上一组数据前面加0，再上一组数据前面加1的逆序
    //00,01,11,10
    //
    public static String[] getGray(int n) {
        String[] resStrs = null;
        if(n == 1){
            resStrs = new String[]{"0","1"};
        }
        else{
            String[] strs = getGray(n-1);
            resStrs = new String[2*strs.length]; //格雷码计算方式，前一次格雷码分两部分
            for(int i=0; i<strs.length; i++){
                resStrs[i] = "0"+strs[i];//前半部分的二进制码前加 0
//                resStrs[resStrs.length-1-i] = "1"+strs[i];//后半部分的二进制码前加1
                resStrs[i+2] = strs[i]+"1";
            }
        }
        return resStrs;
    }
}