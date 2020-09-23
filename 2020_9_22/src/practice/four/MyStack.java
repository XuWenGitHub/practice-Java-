package practice.four;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @PackgeName: practice.four
 * @ClassName: MyStack
 * @Author: XuWen
 * Date: 2020/9/22 21:39
 * Introduce:
 */
 public class MyStack {
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue =  new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for(int i=0;i<queue.size()-1;i++){
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        int val = 0;
        for(int i=0;i<queue.size();i++){
            if(i==queue.size()-1){
                val=queue.poll();
                queue.add(val);
            }else{
                queue.add(queue.poll());
            }
        }
        return val;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}