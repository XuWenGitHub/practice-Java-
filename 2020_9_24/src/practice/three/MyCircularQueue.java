package practice.three;

/**
 * @PackgeName: practice.three
 * @ClassName: MyCircularQueue
 * @Author: XuWen
 * Date: 2020/9/26 0:10
 * Introduce:
 */
public class MyCircularQueue {
    private final int[] queue;
    private int front;  //队列首下标,指向当前第一个元素
    private int rear;   //指向最后一个元素的下一个
    private int maxSize;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k+1];   //因为我们空一个空间不用，来判断是否满了
        front=0;
        rear=0;
        maxSize=k+1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    //
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        queue[rear] = value;
        rear = (rear+1)%maxSize;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front=(front+1)%maxSize;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return queue[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        if(rear==0){
            return queue[maxSize-1];
        }
        return queue[rear-1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return rear==front;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (rear+1)%maxSize==front;
    }
}
