package practice.five;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackgeName: practice.five
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/23 11:19
 * Introduce:用队列模拟栈的实现
 */
public class Demo {
    private Deque<Integer> queue = new LinkedList<>();  //队列

    //压栈
    public void push(Integer e){
        queue.add(e);
    }

    //弹栈
    public Integer pop(){
        for(int i=0;i<queue.size()-1;i++){
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    //查看栈顶元素
    public Integer peek(){
        int val=0;
        for(int i=0;i<queue.size();i++){
            if(i==queue.size()-1){
                val = queue.poll();
                queue.add(val);
            }else{
                queue.add(queue.poll());
            }
        }
        return val;
    }

    //返回栈中的元素个数
    public int size(){
        return queue.size();
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        d.push(1);
        d.push(2);
        d.push(3);
        d.push(4);
        d.push(5);
        System.out.println(d.peek());
        System.out.println(d.pop());
        System.out.println(d.peek());
        System.out.println(d.pop());
        System.out.println(d.pop());
        System.out.println(d.peek());

        //不相同
    }
}
