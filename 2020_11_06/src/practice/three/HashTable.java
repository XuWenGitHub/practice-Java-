package practice.three;

/**
 * @PackgeName: practice.three
 * @ClassName: HashTable
 * @Author: XuWen
 * Date: 2020/11/6 23:01
 * Introduce:
 */
public class HashTable {

    Node[] arr;
    int size;
    public HashTable(){
        arr = new Node[16];
        size = 0;
    }

    public boolean remove(Integer val){
        //1.先根据hashcode方法，获取当前待添加值的哈希值
        int hash = val.hashCode();
        //2.获取根据hash获取合法的下标,java中n - 1 & hash获取的，n表示数组的长度，我们这里就用取模了,但是一般线性探测用取模法用的多
        int index = arr.length%hash;
        Node cur = arr[index];
        Node pre = null;
        while (cur!=null){
            if(cur.val.equals(val)){
                if(pre==null){
                    arr[index] = arr[index].next;
                }else {
                    pre.next = cur.next;
                }
                return true;
            }
            pre = cur;
            cur = cur.next;
        }
        return false;
    }

    public boolean contains(Integer val){
        //1.先根据hashcode方法，获取当前待添加值的哈希值
        int hash = val.hashCode();
        //2.获取根据hash获取合法的下标,java中n - 1 & hash获取的，n表示数组的长度，我们这里就用取模了,但是一般线性探测用取模法用的多
        int index = arr.length%hash;
        Node cur = arr[index];
        while (cur!=null){
            if(cur.val.equals(val)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void add(Integer val){
        //1.先根据hashcode方法，获取当前待添加值的哈希值
        int hash = val.hashCode();
        //2.获取根据hash获取合法的下标,java中n - 1 & hash获取的，n表示数组的长度，我们这里就用取模了,但是一般线性探测用取模法用的多
        int index = arr.length%hash;
        //先构造一个节点
        Node node = new Node(val);
        //3.判断index位置是有元素
        if(arr[index]==null){
            arr[index] = node;
        }else{  //哈希冲突了
            //头插
            node.next = arr[index];
            arr[index]=node;
        }
        size++;
        //4.根据负载因子是否>0.75，如果大了，就要扩容，负载因子就是：当前哈希表中元素个数/数组大小
    }

    static class Node{
        Integer val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
