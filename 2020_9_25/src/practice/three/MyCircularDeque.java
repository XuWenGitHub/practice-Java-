package practice.three;

/**
 * @PackgeName: practice.three
 * @ClassName: MyCircularDeque
 * @Author: XuWen
 * Date: 2020/9/25 23:57
 * Introduce:设计循环双端队列
 */
public class MyCircularDeque {
    private int[] deque;    //存放双端队列的数组
    private int frontIndex; //表示双端队列队首下标,指向队列头部第一个有效元素
    private int rearIndex;  //表示双端队列队尾下标,一直指向双端队列队尾的下一个位置
    private int size;   //表示当前循环双端队列的元素个数
    private final int MAXSIZE;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        deque = new int[k];
        frontIndex = 0;
        rearIndex = 0;
        size = 0;
        MAXSIZE = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        if(frontIndex==0){
            deque[MAXSIZE-1] = value;
            frontIndex = MAXSIZE-1;
        }else{
            deque[frontIndex-1] = value;
            frontIndex = frontIndex-1;
        }
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        deque[rearIndex] = value;
        size++;
        rearIndex = (rearIndex+1)%MAXSIZE;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        frontIndex = (frontIndex+1)%MAXSIZE;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        if(rearIndex==0){
            rearIndex = MAXSIZE-1;
        }else{
            rearIndex--;
        }
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return deque[frontIndex];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        if(rearIndex==0){
            return deque[MAXSIZE-1];
        }
        return deque[rearIndex-1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size==MAXSIZE;
    }
}
