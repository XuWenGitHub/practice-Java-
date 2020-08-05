package practice.one;

import java.util.Scanner;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/5 10:20
 * Introduce:   练习
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("成功");
        //System.
    }

    public static String strCat(String s1,String s2){
        return s1.concat(s2);
    }

    public static boolean isNumStr(String str){
        char[] arr = str.toCharArray();
        for(char ch:arr){
            if(ch<'0'||ch>'9'){
                return false;
            }
        }
        return true;
    }
}
