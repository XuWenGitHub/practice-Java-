package practice.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/24 18:59
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Deque<Integer> stack = new LinkedList<>();
        int pushIndex = 0;
        int popIndex = 0;
        while(pushIndex<pushA.length&&popIndex<popA.length){
            if(pushA[pushIndex]!=popA[popIndex]){
                stack.push(pushA[pushIndex]);
                pushIndex++;
            }else{
                popIndex++;
                pushIndex++;
            }
        }
        while(!stack.isEmpty()){
            if(stack.pop()==popA[popIndex]){
                popIndex++;
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean IsPopOrder2(int[] pushA, int[] popA) {
        List<Integer> pushList = intArrayToList(pushA);
        List<Integer> popList = intArrayToList(popA);

        // 实现准备的栈;
        Deque<Integer> stack = new LinkedList<>();

        // 数组不能通过 length 判断，通过几个下标去判断，比较麻烦
        // 所以建议大家平时遇到 OJ 题时，多使用 List
        // while (只要 popA 还没有空) {
        while (!popList.isEmpty()) {
            //int p = popA 取出第一个元素;
            int p = popList.remove(0);

            while (true) {
                if (stack.isEmpty() || stack.peek().intValue() != p) {
                    //if (栈是空的 || 栈顶元素 != p) {
                    if (pushList.isEmpty()) {
                        //if (pushA 是空的){
                        return false;
                    }

                    // int q = pushA 取出第一个元素;
                    int q = pushList.remove(0);
                    // 把 q 压入栈中
                    stack.push(q);
                } else {
                    break;
                }
            }

            // 弹出栈顶元素
            stack.pop();
        }

        return stack.isEmpty();
    }
    // 重要程度排序：优先代码正确 > 其次考虑效率（尤其时间复杂度一样，只是系数不同的效率，现在更不需要考虑）
    private List<Integer> intArrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        return list;
    }
}
