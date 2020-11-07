package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: MyHashMap
 * @Author: XuWen
 * Date: 2020/11/7 22:39
 * Introduce:
 */
class MyHashMap {
    Node[] arr;
    int size;
    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new Node[10];
        this.size = 0;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node node = new Node(key,value);
        int hash = node.hashCode();
        int index = hash%arr.length;
        Node cur = arr[index];
        if(cur==null){
            arr[index] = node;
        }else{
            Node pre = null;
            while(cur!=null){
                if(cur.key==key){
                    cur.value = value;
                    return;
                }
                pre = cur;
                cur = cur.next;
            }
            if(pre==null){
                cur.next = node;
            }else{
                pre.next = node;
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key;
        int index = key%arr.length;
        Node cur = arr[index];
        while(cur!=null){
            if(cur.key==key){
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key;
        int index = key%arr.length;
        Node cur = arr[index];
        Node pre = null;
        while(cur!=null){
            if(cur.key==key){
                if(pre==null){
                    arr[index] = cur.next;
                }else{
                    pre.next= cur.next;
                }
            }
            pre = cur;
            cur = cur.next;
        }
    }
    static class Node{
        int key;
        int value;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
        public int hashCode(){
            return key;
        }
        public boolean equals(Node node){
            return this.key==node.key&&this.value==node.value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
