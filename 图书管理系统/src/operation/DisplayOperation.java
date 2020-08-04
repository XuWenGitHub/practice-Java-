package operation;

import book.Book;
import book.BookLinkedList;

public class DisplayOperation implements IOperation {
    @Override
    public void work(BookLinkedList bookLinkedList) {
        Book cur = bookLinkedList.getHead();
        while(cur!=null){
            System.out.println(cur);
            cur=cur.getNext();
        }
    }
}
