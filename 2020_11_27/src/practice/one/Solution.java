package practice.one;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();    //push栈
    Stack<Integer> stack2 = new Stack<Integer>();    //pop栈

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
