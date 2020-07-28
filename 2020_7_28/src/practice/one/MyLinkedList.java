package practice.one;

/**
 * 单向不带头的非循环链表
 */
public class MyLinkedList {
    private Node head;  //单链表的第一个有效节点

    //构造器
    public MyLinkedList(){

    }

    //判断链表是否为空
    public boolean isNull(){
        return head==null;
    }

    //清空链表
    public void clear(){
        head=null;
    }

    //判断链表中是否有key
    public boolean contains(int key){
        Node cur = head;
        while(true){
            if(cur==null){
                return false;
            }
            if(cur.getData()==key){
                return false;
            }
            cur=cur.getNext();
        }
    }

    //删除所有值为key的节点
    public void deleteAllKey(int key){
        while (head != null) {
            if (head.getData() == key) {
                head = head.getNext();  //每次进来判断第一个有效节点是否是key
                continue;
            }
            Node cur = findData(key);//从第二个有效节点开始判断是不是key，如果找到key，返回key值节点的上一个节点
            if (cur == null) {
                break;  //说明没找到
            } else {
                cur.setNext(cur.getNext().getNext());
            }
        }
    }

    //删除第一次出现关键字key的节点
    public void delete(int date){
        //先要判断链表是否为空
        if(head==null){
            System.out.println("链表为空，删除失败");
            return;
        }
        //如果data为第一个有效节点，删除第一个有效节点
        if(head.getData()==date){
            head=head.getNext();
            System.out.println("删除成功");
            return;
        }
        //找到值为data的前面一个节点,但是data不能是一个有效节点，所以上面判断了
        Node cur = findData(date);
        if(cur!=null){
            cur.setNext(cur.getNext().getNext());
            System.out.println(date+"删除成功");
        }else {
            System.out.println("删除失败，没有找到"+date);
        }
    }

    //查找值为date节点的上一个节点，如果找到返回该节点，找不到返回null
    //但data不能为第一个有效节点,因为这是不带头结点的单链表
    public Node findData(int data){
        Node cur = head;
        while (cur.getNext() != null) {
            if (cur.getNext().getData() == data) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }

    //头插法
    public void addFrist(int data){
        Node node = new Node(data);
        //先判断head的next是否为空
        if (!isNull()) {
            node.setNext(head);
        }
        this.head=node;
    }

    //判断index下标是否有误
    public boolean cheackIndex(int index){
        if(index<0||index>getLength()){
            System.out.println("index有误");
            return false;
        }
        return true;
    }

    //插入到index下标，定义规则，第一个节点的下标为0
    //先判断index是否为0，如果为0，直接插入，然后return
    //现在判断index-1下标位置是否为空，如果为空，插入不了，
    //如果不为空，才可以插入
    public void addIndex(int index,int data){
        Node node = new Node(data);
        if(!cheackIndex(index)){
            return;
        }
        if(index==0){
            addFrist(data);
            return;
        }
        Node cur = searchPrev(index);
        if(cur!=null){
            node.setNext(cur.getNext());
            cur.setNext(node);
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
    }

    /**
     * 查找index-1的位置，找到返回引用,index不能为0,找不到返回null
     * @param index 下标
     * @return  Node节点
     */
    public Node searchPrev(int index){
        if(index<=0){
            return null;
        }
        Node cur = head;
        int index2=0;   //代表cur的index,如果到index-1位置停止
        while (cur.getNext() != null && index2 != index - 1) {
            cur = cur.getNext();
            index2++;
        }
        if(index2==index-1){
            return cur;
        }
        return null;    //表示index-1位置为null
    }

    /**
     * 获取当前链表的长度
     * @return  链表的长度
     */
    public int getLength(){
        int len=0;
        Node cur = head;
        while(cur!=null){
            len++;
            if(cur.getNext()==null){
                break;
            }
            cur=cur.getNext();
        }
        return len;
    }

    //按data从小到大添加元素，依然有序，从小到大
    public void addSort(int data){
        Node node = new Node(data);
        if(isNull()){
            this.head=node;
            return;
        }
        //先判断head节点,因为没有头结点，head里面就存的有效的,
        //这个if跳过后下面就直接判断head.next.data的值
        if(head.getData()>data){
            addFrist(data);
            return;
        }
        //表示链表里面有节点了,现在需要找到比他值大的节点的前一个节点
        //但是我们不需要判断第一个了，因为上面判断过了
        Node cur = head;
        while (cur.getNext() != null && cur.getNext().getData() <= data) {
            cur = cur.getNext();
        }
        //退出循环后，就应该要插入到cur这个节点的后面
        node.setNext(cur.getNext());
        cur.setNext(node);
    }

    //尾插法
    public void addLast(int data){
        Node node = new Node(data); //表示当前待插入节点
        //先判断链表是否为空
        if(isNull()){
            this.head=node;
            return;
        }
        Node cur = head;    //辅助节点，遍历链表
        while (cur.getNext() != null) {
            cur = cur.getNext();  //后移
        }
        cur.setNext(node);
    }

    //遍历链表
    public void list(){
        if(isNull()){
            System.out.println("链表为空");
            return;
        }
        Node cur = head;
        while(true){
            System.out.print(cur.getData()+" ");
            if(cur.getNext()==null){
                break;
            }
            cur=cur.getNext();
        }
        System.out.println();
    }

}
