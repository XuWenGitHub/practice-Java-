/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: Main
 * @Author: XuWen
 * Date: 2020/8/8 10:15
 * Introduce:
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
public class Main{
    public static void main(String[] args){
        //List<Character> list = new ArrayList<Character>();
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        System.out.println(findString(str));
        System.out.println(100%3.0);
    }
    public static String findString(String str){
        if(str==null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> array = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!array.contains(ch)){
                array.add(ch);
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}