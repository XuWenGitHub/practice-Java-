package practice.two;

import java.util.Deque;
import java.util.LinkedList;

public class Main {


    public class Parenthesis {
        public boolean chkParenthesis(String A, int n) {
            // write code here
            Deque<Character> stack = new LinkedList<>();
            for(int j=0;j<n;j++){
                char ch = A.charAt(j);
                if(ch=='('){
                    stack.push(ch);
                }else if(ch==')'){
                    if(stack.isEmpty()){
                        return false;
                    }
                    if(stack.pop()!='('){
                        return false;
                    }
                }else{
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
