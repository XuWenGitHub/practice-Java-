package operation;

import book.Book;
import book.BookLinkedList;

import java.util.Scanner;

public class FindOperation implements IOperation {
    @Override
    public void work(BookLinkedList bookLinkedList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要查找的书名");
        String findName = sc.next();
        Book book = bookLinkedList.getHead();
        while (book!=null){
            if(book.getName().equals(findName)){
                System.out.println("找到"+findName+"该本书");
                System.out.println(book);
                return;
            }
            book = book.getNext();
        }
        System.out.println("没有找到"+findName+"该本书");
    }
}
