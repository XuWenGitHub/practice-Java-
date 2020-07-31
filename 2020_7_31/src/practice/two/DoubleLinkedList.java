package practice.two;

import java.util.ArrayList;

public class DoubleLinkedList {
    private Node head;  //这是第一个有效节点

    private Node tail;  //这是最后一个有效节点

    //判断链表是否为空
    public boolean isEmpty(){
        return this.head==null;
    }

    //头插法,tail不会变
    public void addFrist(int data){
        Node node = new Node(data);
        if(isEmpty()){
            this.head=node;
            this.tail=node;
            return;
        }
        node.setNext(head);
        head.setPrev(node);
        head=node;
//        Node tmp = head;  //保存当前head节点
//        head=node;  //让head=node
//        node.setNext(tmp);  //让node指向tmp
//        tmp.setPrev(node);  //让tmp前驱指向node
        //tail=tmp;   //让tail指向最后一个有效元素
    }


    //尾插法
    public void addLast(int data){
        Node node = new Node(data); //待插入节点
        if(isEmpty()){
            head=node;
            tail=node;
            return;
        }
        tail.setNext(node);
        node.setPrev(tail);
        tail=node;
    }

    //返回链表的长度
    public int getLen(){
        if(isEmpty()){
            return 0;
        }
        Node cur = head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.getNext();
        }
        return len;
    }

    //任意位置插入，第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        //如果index如果是0就头插法，如果index是链表长度就尾插法
        if(index==0){
            addFrist(data);
            System.out.println("插入成功");
            return true;
        }
        if(index==getLen()){
            addLast(data);
            System.out.println("插入成功");
            return true;
        }
        Node newNode = new Node(data);  //待插入节点
        Node indexNode = findIndexNode(index);  //当前index下标的节点
        if(indexNode==null){
            System.out.println("index不合法");
            return false;
        }
        //保存当前index下标节点的前驱
        Node indexNodePrev=indexNode.getPrev();
        //index节点的前驱节点的指向新的节点
        indexNodePrev.setNext(newNode);
        //新的节点后继变成index节点
        newNode.setNext(indexNode);
        //新的节点前驱变成index节点的前驱节点
        newNode.setPrev(indexNodePrev);
        //index节点的前驱要变成新节点
        indexNode.setPrev(newNode);
        System.out.println("插入成功");
        return true;
    }
    //寻找下标为index的节点，第一个有效节点下标为0
    // 找到了返回该节点，没找到返回null
    public Node findIndexNode(int index){
        if(index<0){
            return null;
        }
        Node cur = head;
        while(index>0){
            //如果index不合法
            if(cur.getNext()==null){
                return null;
            }
            cur=cur.getNext();
            index--;
        }
        return cur;
    }


    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        if(isEmpty()){
            return false;
        }
        Node cur = head;
        while(cur!=null){
            if(cur.getData()==key){
                return true;
            }
            cur=cur.getNext();
        }
        return false;
    }

    //删除所有关键字为key的节点
    public boolean deleteAll(int key){
        if(isEmpty()){
            System.out.println("链表为空");
            return false;
        }
        Node frist=null;    //如果第一个值也为key，最后删
        Node last=null;     //如果最后一个值也为key，最后删
        ArrayList<Node> keyArray = findKeyAll(key);
        if(keyArray.isEmpty()){
            System.out.println("没有找到值为"+key+"节点");
            return false;
        }else{
            for(Node keyNode:keyArray){
                //先判断是否是第一个或者是否是最后一个
                if(keyNode==this.head){
                    frist=keyNode;
                }else if(keyNode==this.tail){
                    last=keyNode;
                }else{
                    //这就表示是中间的元素
                    keyNode.getPrev().setNext(keyNode.getNext());
                    keyNode.getNext().setPrev(keyNode.getPrev());
                }
            }
        }
        //现在删除第一个和最后一个
        if(frist!=null){
            this.head=head.getNext();
            this.head.setPrev(null);
        }
        if(last!=null){
            this.tail=tail.getPrev();
            this.tail.setNext(null);
        }
        System.out.println("删除"+key+"成功");
        return true;
    }
    //在链表里找值为key的，找到了，存入ArrayList里面，最后返回
    public ArrayList<Node> findKeyAll(int key){
        ArrayList<Node> arrayList = new ArrayList<>();
        Node cur = head;
        while(cur!=null){
            if(cur.getData()==key){
                arrayList.add(cur);
            }
            cur=cur.getNext();
        }
        return arrayList;
    }

    //删除第一次出现关键字为key的节点
    public boolean delete(int key){
        if(isEmpty()){
            System.out.println("链表为空，删除失败");
            return false;
        }
        if(head.getData()==key){
            head=head.getNext();
            head.setPrev(null);
            System.out.println("删除"+key+"成功");
            return true;
        }
        if(tail.getData()==key){
            tail.getPrev().setNext(null);
            tail=tail.getPrev();
            System.out.println("删除"+key+"成功");
            return true;
        }
        Node keyNode =findKeyNode(key);
        if(keyNode==null){
            System.out.println("没找到"+key+"节点");
            return false;
        }
        keyNode.getPrev().setNext(keyNode.getNext());
        keyNode.getNext().setPrev(keyNode.getPrev());
        System.out.println("删除"+key+"成功");
        return true;
    }
    //寻找第一次出现关键字的key节点，
    //找到返回该节点，没有找到返回null
    public Node findKeyNode(int key){
        if(isEmpty()){
            return null;
        }
        Node cur = head;
        while(cur!=null){
            if(cur.getData()==key){
                return cur;
            }
            cur=cur.getNext();
        }
        return null;
    }

    //遍历链表
    public void list(){
        if(isEmpty()){
            System.out.println("链表为空");
            return;
        }
        Node cur = head;
        while(cur!=null){
            System.out.print(cur.getData()+" ");
            cur=cur.getNext();
        }
        System.out.println();
    }

    public void clear(){
        Node cur = this.head;
        while (cur!=null){
            Node curNext = cur.getNext();
            cur.setNext(null);
            cur.setPrev(null);
            cur=curNext;
        }
        this.head=null;
        this.tail=null;
    }
}
