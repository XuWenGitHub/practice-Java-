package practice.one;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getMaxStr(str));
    }
    public static String getMaxStr(String str){
        StringBuilder sb = new StringBuilder();
        int maxLen = 0;
        String res = null;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='0'&&ch<='9'){
                sb.append(ch);
            }else{
                if(sb.length()>maxLen){
                    res = sb.toString();
                    maxLen = res.length();
                }
                sb = new StringBuilder();
            }
        }
        if(sb.length()>maxLen){
            res = sb.toString();
            maxLen = res.length();
        }
        return res;
    }
}