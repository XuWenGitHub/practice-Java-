package practice.one;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/25 23:54
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    //3.栈的弹出压入序列
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Deque<Integer> stack = new LinkedList<>();
        int pushIndex = 0;    //表示压栈的下标
        int popIndex = 0;    //表示弹栈的下标
        //pushA[pushIndex]==popA[popIndex]，两个下标后移
        //pushA[pushIndex]！=popA[popIndex]
        //先判断，如果栈不为空，并且peek一下栈顶元素和popA[popIndex]是否相等
        //相等：栈pop，popIndex++，continue
        //如果不相等：把pushA[pushIndex]压入栈中,pushIndex++
        while(pushIndex<pushA.length&&popIndex<popA.length){
            //如果相等，就两个下标一起跳
            //如果不相等，先判断和栈顶一样吗，如果一样，弹栈，popIndex++
            //如果不一样，那么压栈
            if(pushA[pushIndex]==popA[popIndex]){
                pushIndex++;
                popIndex++;
            }else{
                if(!stack.isEmpty()&&stack.peek()==popA[popIndex]){    //判断是否和栈顶一样
                    stack.pop();
                    popIndex++;
                    continue;
                }
                stack.push(pushA[pushIndex]);
                pushIndex++;
            }
        }
        //如果栈为空，那么为真，如果栈不为空，栈弹一个，比一个，如果不相等直接返回false
        while(!stack.isEmpty()){
            if(stack.pop()==popA[popIndex]){
                popIndex++;
            }else{
                return false;
            }
        }
        return true;
    }

}
