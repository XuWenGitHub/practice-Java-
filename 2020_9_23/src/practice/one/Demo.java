package practice.one;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/23 16:32
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    //遇到数字入栈，遇到运算符则取出栈顶两个数字进行计算，并将结果压入栈中
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        Integer num1,num2;
        for(int i=0;i<tokens.length;i++){
            String s = tokens[i];   //一个一个取出
            switch(s){
                case "+":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2+num1);
                    break;
                case"-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2-num1);
                    break;
                case"*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2*num1);
                    break;
                case"/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2/num1);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
