package practice.three;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/22 20:44
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
    public static boolean isValid(String s) {
        //准备一个栈
        Deque<Character> stack = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='['){ //表示是个左括号
                stack.push(c);
            }else{  //表示是个右括号
                if(stack.isEmpty()){    //栈为空
                    return false;   //表示右括号多了
                }else{  //栈不为空

                    if(!split(stack.pop(),c)){
                        return false;   //表示左右括号不匹配
                    }
                }
            }
        }
        if(stack.isEmpty()){    //表示正确
            return true;
        }else{//表示左括号多了
            return false;
        }
    }
    public static boolean split(char a,char b){
        if(a=='('&&b==')'){
            return true;
        }
        if(a=='['&&b==']'){
            return true;
        }
        if(a=='{'&&b=='}'){
            return true;
        }
        return false;

    }
}
