package practice.one;

/**
 * 单向不带头的非循环链表
 */
public class MyLinkedList {
    private Node head;  //单链表的第一个有效节点

    //构造器
    public MyLinkedList(){

    }
    public Node getHead(){
        return head;
    }
    public void setHead(Node head){
        this.head=head;
    }

    //判断链表是否为空
    public boolean isNull(){
        return head==null;
    }

    //给定一个链表，链表有环，返回环的入口点
    public Node asd(){
        Node slow = head;
        Node fast = head;
        //先一个走一步，一个走两步
        while(fast!=null&&fast.getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.getNext()==null){
            return null;    //说明没有环
        }
        //当退出循环，两者第一次相遇,然后slow变成初始地点
        slow = head;
        //然后一人一步走，相遇了就返回相遇的节点,相遇的节点就是环的入口点
        while (slow!=fast){
            slow=slow.getNext();
            fast=fast.getNext();
        }
        return slow;
    }

    //给定一个链表，判断是否有环
    //一个走一步，一个走两步,如果有环，肯定会相遇
    public boolean hasCycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
            if(slow==fast){
                return true;
            }
        }
        return false;
    }


    //判断链表是否是回文结构
    //先找到链表的中间节点
    //然后从中间节点到链表尾部进行反转
    //再从head往后走，反转后的最后一个结点往前走，如果值相等，head往前，最后一个节点往前走
    //直到head==最后一个节点，退出循环
    //循环里面要判断，如果head.next==最后一个节点.next，那么说明链表是偶数，而且是回文链表，return true
    public boolean chkPalindrome(){
        if(this.head==null){
            return false;
        }
        if(this.head.getNext()==null){
            return true;
        }
        Node cur = head;    //这个是从前往后遍历
        //先找到中间节点
        Node slow = findMid();
        Node slowCur = slow.getNext();
        //再反转中间节点后面的
        while(slowCur!=null){
            Node slowNext = slowCur.getNext();
            slowCur.setNext(slow);
            slow=slowCur;
            slowCur=slowNext;
        }
        //退出上面循环后，slow指向最后一个有效节点，cur指向第一个有效节点
        //两指针向中间遍历，判断值是否一样，如果不一样。return false
        while(slow!=cur){
            if(slow.getData()!=cur.getData()){
                return false;
            }
            //为了偶数节点来实现的
            if(cur.getNext()==slow){
                return true;
            }
            slow=slow.getNext();
            cur=cur.getNext();
        }
        return true;
    }

    //删除这个链表重复的节点(这个链表有序)
    public void deleteRepeat(){
        Node newHead = new Node(-1);    //傀儡节点
        Node cur = head;    //遍历链表
        Node tmp=newHead;  //遍历傀儡节点
        while(cur!=null){
            if(cur.getNext()!=null&&cur.getData()==cur.getNext().getData()){
                //进入循环
                while (cur.getNext()!=null&&cur.getData()==cur.getNext().getData()){
                    cur=cur.getNext();
                }
                cur=cur.getNext();  //为什么对走一步，画图自己想
            }else{
                tmp.setNext(cur);
                tmp=cur;
                cur=cur.getNext();
            }
        }
        tmp.setNext(null);
        this.head=newHead.getNext();
    }

    public Node partition(int x){
        Node bs=null;
        Node be = null;

        Node as=null;
        Node ae=null;

        Node cur = head;
        while(cur!=null){
            if(cur.getData()<x){
                if(bs==null){
                    //第一次进行插入
                    bs=cur;
                    be=cur;
                }else {
                    be.setNext(cur);
                    be=cur;
                }
            }else{
                if(as==null){
                    //第一次和进行插入（尾插法）
                    as=cur;
                    ae=as;
                }else{
                    ae.setNext(cur);
                    ae=cur;
                }
            }
            cur=cur.getNext();
        }

        if(bs==null){
            return as;
        }
        be.setNext(as);
        if(as!=null){
            ae.setNext(null);
        }
        return bs;
    }

    //输入一些节点，寻找倒数第k个节点
    //定义两个指针，都开始指向head，一个先走k步，一个不走
    //然后两个一起往后走，当先走k步的那个，变成了null，输出走得慢的
    //如果返回为null说明，说明k有误，那就说明fast一步没走，或者fast走了比长度还长的步数
    public Node findLastK(int k){
        Node slow=head;
        Node fast=head;
        //先让fast先走k步
        //如果k=0或者负数，一步都不走，然后最后还是返回null
        for(int i=0;i<k;i++){
            assert fast != null;
            if(fast.getNext()==null&&i!=k-1){
                //如果fast先走的次数大于长度，说明k有误
                return null;
            }
            fast=fast.getNext();
        }
        while(fast!=null){
            slow=slow.getNext();
            fast=fast.getNext();
        }
        return slow;
    }


    //寻找链表的中间节点，只允许遍历一遍链表
    public Node findMid(){
        Node slow = head;
        Node fast=head;
        while(fast!=null&&fast.getNext()!=null){
            slow=slow.getNext();  //low走一步
            fast = fast.getNext().getNext();    //fast走两步
        }
        return slow;
    }

    //反转单链表,第二种方法,三个指针,前驱和指向待反转的节点和后继
    public Node reverse(){
        Node newNode = null;    //最后返回的节点
        Node cur = head;    //代表当前需要反转的节点
        Node prev = null;   //代表前驱
        Node curNext=null;  //代表后继
        while(cur!=null){
            if(cur.getNext()==null){
                //要把newNode=cur
                newNode=cur;
            }
            curNext=cur.getNext(); //记录后继
            cur.setNext(prev);  //cur反向指，第一次指向null
            prev=cur;   //重置前驱
            cur=curNext;    //重置需要反转的节点，也就是下一个节点
        }
        return newNode;
    }

    //反转单链表,遍历每一个插入到新链表的第一个位置
    public void reverse2(){
        //先定义一个temp链表
        Node temp = null;
        //遍历单链表，循环每次插入到temp链表的最前面
        Node cur = head;
        Node tempNext =temp;    //保存现在的temp
        while (cur != null) {
            Node curNext = cur.getNext();   //保存cur的后继节点位置
            temp = cur; //cur变成新链表的第一个
            cur.setNext(tempNext);  //
            tempNext = cur; //让其变成temp链表的第二个有效节点
            cur = curNext;  //让cur后移
        }
        this.head=temp; //最后让head=temp就是链表赋给head
    }

    //清空链表,防止内存泄漏，要从倒数第二个开始清空
    public void clear(){
        this.head=null;
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

    //删除所有值的key的节点
    //只遍历一遍链表即可
    //定义prev指向第一个有效节点，cur指向第二个有效节点
    //prev指向cur的前驱节点，如果cur该节点值是可以，删除了后，prev不能走，cur往后走
    //如果没有删除，prev先指向cur指向的东西，然后cur再后移一下,继续保持prev是cur的前驱结点
    public void deleteAllKey2(int key){
        if(this.head==null){
            return;
        }
        Node prev=head;
        Node cur = head.getNext();
        while (cur != null) {
            //判断cur的值是不是key，但是没有判断第一个有效节点，退出循环后，补上
            if (cur.getData() == key) {
                prev.setNext(cur.getNext());    //删除cur节点
            } else {
                //cur指向的节点不等于key
                prev = cur;   //移到cur处
            }
            cur = cur.getNext();  //cur后移
        }
        //最后删除完了，但是第一个有效节点没有判断
        if(head.getData()==key){
            head=head.getNext();
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
