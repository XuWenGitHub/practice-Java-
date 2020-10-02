package practice.one;

import java.util.*;

class Node<T>{
    public T val;
    public Node<T> next;
    public Node<T> prev;

    public Node(T val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(val, node.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}

/**
 * @PackgeName: practice.one
 * @ClassName: MyLinkedList
 * @Author: XuWen
 * Date: 2020/9/21 21:08
 * Introduce:   双向链表实现LinkedList
 */
public class MyLinkedList<T> implements List<T> {
    private Node<T> head;   //第一个有效节点
    private Node<T> tail;   //表示最后一个有效节点
    private int size=0;   //表示有效个数，初始为0

    public MyLinkedList() {

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> cur = head;
        while (cur!=null){
            if(cur.val.equals(o)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] o = new Object[size];
        int index=0;
        Node<T> cur = head;
        while(cur!=null){
            o[index] = cur.val;
            index++;
            cur = cur.next;
        }
        return o;
    }

    @Override
    //size<tis.length,把size个赋值后，下一个位置设置为null
    //size==tis.length,直接赋值，然后返回
    //size>this.length,创建一个新的大小一样的,然后返回
    public <T1> T1[] toArray(T1[] t1s) {
        if(size<t1s.length){
            for(int i=0;i<size;i++){
                t1s[i]=(T1)get(i);
            }
            t1s[size] = null;
            return t1s;
        }else if(size==t1s.length){
            for(int i=0;i<size;i++){
                t1s[i]=(T1)get(i);
            }
            return t1s;
        }else{
            T1[] newArray =(T1[])new Object[size];
            for(int i=0;i<size;i++){
                newArray[i] = (T1)get(i);
            }
            return newArray;
        }

    }

    @Override
    public boolean add(T t) {
        Node<T> node = new Node<>(t);   //待添加的元素
        if(this.head==null){
            head = node;
        }else{
            tail.next=node;
            node.prev = tail;
        }
        tail=node;
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        //先去找有木有o这个元素
        Node<T> cur = head;
        boolean flag=false;
        while(cur!=null){
            if(cur.val.equals(o)){
                flag=true;
                break;
            }
            cur = cur.next;
        }
        if(flag){
            if(cur==head){
                remove(0);
            }else if(cur==tail){
                remove(size-1);
            }else{
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
            }
            size--;
        }
        return flag;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {
        //为了防止内存泄漏
        Node<T> cur = head;
        while(cur!=null){
            Node<T> curNext = cur.next;
            cur.prev=null;
            cur.next=null;
            cur = curNext;
        }
        head=null;
        tail=null;
        size=0;
    }

    @Override
    //返回指定位置的元素
    public T get(int i) {
        if(i<0||i>=size){
            throw new IndexOutOfBoundsException("下标越界异常");
        }
        Node<T> cur;
        //如果i<size/2,就从前面遍历，找到i位置，否则就从后面遍历找到i位置
        if(i<this.size/2){
            cur = head;
            for(int j=0;j<i;j++){
                cur = cur.next;
            }
        }else{
            cur = tail;
            for(int j=1;j<size-i;j++){
                cur=cur.prev;
            }
        }
        return cur.val;
    }

    @Override
    //修改i下表的为t，返回原来的t
    public T set(int i, T t) {
        if(i<0||i>=size){
            throw new IndexOutOfBoundsException("下标越界异常");
        }
        Node<T> cur;
        //如果i<size/2,就从前面遍历，找到i位置，否则就从后面遍历找到i位置
        if(i<this.size/2){
            cur = head;
            for(int j=0;j<i;j++){
                cur = cur.next;
            }
        }else{
            cur = tail;
            for(int j=size-1;j>i;j--){
                cur=cur.prev;
            }
        }
        T re = cur.val;
        cur.val=t;
        return re;
    }

    //头插
    public void addFirst(T t){
        Node<T> node = new Node<>(t);
        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }

    @Override
    //根据下标添加元素
    public void add(int i, T t) {
        if(i<0||i>size){
            throw new IndexOutOfBoundsException("下标越界异常");
        }
        if(i==0){   //头插
            addFirst(t);
            return;
        }
        if(i==size){    //尾插
            add(t);
            return;
        }
        Node<T> cur = head;
        //中间插入
        for(int j=0;j<i;j++){
            cur = cur.next;
        }
        //循环遍历完了后，cur就指向当前待插入元素的位置
        Node<T> curPrev = cur.prev;
        Node<T> curNext = cur;
        cur = new Node<>(t);
        cur.prev = curPrev;
        curPrev.next = cur;
        cur.next = curNext;
        curNext.prev = cur;
        size++;
    }

    @Override
    public T remove(int i) {
        if(i<0||i>=size){
            throw new IndexOutOfBoundsException("下标越界异常");
        }
        Node<T> cur;
        if(i==0){
            cur = head;
            head.next.prev = null;
            head = head.next;
        }else if(i==size-1){
            cur=tail;
            tail.prev.next = null;
            tail = tail.prev;
        }else {
            cur = head;
            for(int j=0;j<i;j++){
                cur = cur.next;
            }
            //cur现在就是待删除元素
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
        size--;
        return cur.val;
    }

    @Override
    //返回o的下标
    public int indexOf(Object o) {
//        if(!(o instanceof ){
//            throw new ClassCastException("类型不兼容错误");
//        }
        //o = (T)o;
        Node<T> cur = head;
        int index=0;
        while(cur!=null){
            if(cur.val.equals(o)){
                return index;
            }
            cur = cur.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> cur = tail;
        int index = size-1;
        while(cur.prev!=null){
            if(cur.val.equals(o)){
                return index;
            }
            index--;
            cur = cur.prev;
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new LinkedList<T>(new MyLinkedList<T>()).listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return new LinkedList<T>(new MyLinkedList<T>()).listIterator(i);
    }

    @Override
    public List<T> subList(int i, int i1) {
        if(i<0||i>=size||i1<i||i1>=size){
            throw new IndexOutOfBoundsException("下标越界异常");
        }
        List<T> list = new MyLinkedList<>();
        while(i<i1){
            list.add(get(i));
            i++;
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> cur = head;
        sb.append("[");
        while(cur!=null){
            if(cur.next==null){ //说明最后一个
                sb.append(cur.val);
            }else{
                sb.append(cur.val).append(", ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
