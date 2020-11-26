package practice.two;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        Set<Character> set = new HashSet<>();
        for(int i=0;i<str2.length();i++){
            set.add(str2.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str1.length();i++){
            char ch = str1.charAt(i);
            if(!set.contains(ch)){
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }
}
