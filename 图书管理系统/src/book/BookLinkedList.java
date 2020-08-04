package book;

public class BookLinkedList {
    private Book head;  //链表第一个有效元素
    private Book tail;  //链表最后一个有效元素

    public BookLinkedList(){
        //一开始就读取文件里面存储的图书吧
    }

    //判断图书管理系统里面是否没有书
    public Boolean isEmpty(){
        return head==null;
    }

    public Book getHead(){
        return head;
    }

    public void setHead(Book head){
        this.head=head;
    }

    public Book getTail() {
        return tail;
    }

    public void setTail(Book tail) {
        this.tail = tail;
    }
}
