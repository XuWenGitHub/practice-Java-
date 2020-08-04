package operation;

import book.Book;
import book.BookLinkedList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookLinkedList bookLinkedList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要借阅的书名");
        String findName = sc.next();
        Book book = bookLinkedList.getHead();
        while (book!=null){
            if(book.getName().equals(findName)){
                //System.out.println("找到"+findName+"该本书");
                if(book.isBorrow()){
                    System.out.println(findName+"已经被借出");
                    return;
                }
                System.out.println("借《"+findName+"》书成功");
                book.setBorrow(true);
                return;
            }
            book = book.getNext();
        }
        System.out.println("没有找到"+findName+"该本书");
    }
}
