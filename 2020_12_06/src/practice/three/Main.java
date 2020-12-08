package practice.three;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //保证不断输入
        while (!in.hasNext("bye")){
            String addend=in.nextLine();
            String augend=in.nextLine();
            System.out.println(AddLongInteger(addend,augend));
        }
    }
    public static String AddLongInteger(String addend,String augend){
        StringBuilder add = reverse(addend);
        StringBuilder aug = reverse(augend);
        StringBuilder res = new StringBuilder();
        int index = add.length();
        boolean flag = true;    //表示add短
        if(aug.length()<add.length()){
            index = aug.length();
            flag = false;   //表示aug短
        }
        int k = 0;  //每次两数相加剩余的
        for(int i=0;i<index;i++){
            int num1 = add.charAt(i)-'0';
            int num2 = aug.charAt(i)-'0';
            int sum = num1+num2+k;
            res.append((sum%10));
            k = sum/10;
        }
        if(flag){
            for(int i=index;i<aug.length();i++){
                int num2 = aug.charAt(i)-'0';
                int sum = num2+k;
                res.append((sum%10));
                k = sum/10;
            }
        }else{
            for(int i=index;i<add.length();i++){
                int num1 = add.charAt(i)-'0';
                int sum = num1+k;
                res.append((sum%10));
                k = sum/10;
            }
        }
        if(k!=0){
            res.append(k);
        }
        return reverse(res.toString()).toString();
    }
    public static StringBuilder reverse(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            sb.append(str.charAt(i));
        }
        return sb;
    }
}
