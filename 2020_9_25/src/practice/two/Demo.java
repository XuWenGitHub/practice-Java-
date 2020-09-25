package practice.two;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/25 23:55
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }

    //比较含退格的字符串是否一样
    public boolean backspaceCompare(String S, String T) {
        return backspace(S).equals(backspace(T));
    }
    //退化空格,但退化后，字符串是反着的，但是两个都反着的，没关系
    public String backspace(String s){
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();

    }

}
