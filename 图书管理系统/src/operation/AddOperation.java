package operation;

import book.Book;
import book.BookLinkedList;

import java.util.Scanner;

public class AddOperation implements IOperation {
    @Override
    public void work(BookLinkedList bookLinkedList) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("添加图书");
        System.out.println("请输入书名：");
        String name = sc.next();
        System.out.println("请输入作者：");
        String author = sc.next();
        System.out.println("请输入价钱：");
        int price = sc.nextInt();
        System.out.println("请输入类型：");
        String type = sc.next();
        Book book = new Book(name,author,price,type);
        if(bookLinkedList.getHead()==null){
            bookLinkedList.setHead(book);
        }else{
            bookLinkedList.getTail().setNext(book);
        }
        bookLinkedList.setTail(book);
        System.out.println("添加图书成功");
    }
}
