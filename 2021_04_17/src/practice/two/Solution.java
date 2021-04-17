package practice.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        temp = new LinkedList<>();
        dfs(n,0,0);
        return res;
    }
    List<String> res;
    LinkedList<Character> temp;
    //right代表右括号的个数
    public void dfs(int n,int left,int right){
        if(right==n){   //如果右括号够n个了，那么直接保存结果
            StringBuilder sb = new StringBuilder();
            for(Character ch:temp){
                sb.append(ch);
            }
            res.add(sb.toString());
            return;
        }else{  //右括号不够
            if(left<n){ //判断左括号不够
                if(left!=right){    //左括号和右括号不相等，右括号比左括号少
                    //去匹配一个左括号or去匹配一个右括号
                    temp.addLast('(');
                    dfs(n,left+1,right);
                    temp.removeLast();

                    temp.addLast(')');
                    dfs(n,left,right+1);
                    temp.removeLast();
                }else{  //左括号和右括号相等，只能去匹配左括号
                    temp.addLast('(');
                    dfs(n,left+1,right);
                    temp.removeLast();
                }
            }else{  //左括号够了，只能匹配右括号
                temp.addLast(')');
                dfs(n,left,right+1);
                temp.removeLast();
            }
        }
    }
}