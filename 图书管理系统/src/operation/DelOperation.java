package operation;

import book.Book;
import book.BookLinkedList;

import java.util.Scanner;

public class DelOperation implements IOperation {
    @Override
    public void work(BookLinkedList bookLinkedList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的书名");
        String findName = sc.next();
        if(bookLinkedList.getHead()==null){
            System.out.println("图书系统为空~~~");
            return;
        }

        Book book = bookLinkedList.getHead();
        while (book!=null){
            Book bookNext = book.getNext();
            if(bookNext!=null&&bookNext.getName().equals(findName)){
                if(bookNext==bookLinkedList.getTail()){
                    bookLinkedList.setTail(book);
                }
                book.setNext(bookNext.getNext());
                System.out.println("《"+findName+"》删除成功");
                return;
            }
            book = book.getNext();
        }
        //判断是不是第一本书
        if(bookLinkedList.getHead().getName().equals(findName)){
            bookLinkedList.setHead(bookLinkedList.getHead().getNext());
            System.out.println("《"+findName+"》删除成功");
            return;
        }
        System.out.println("没有找到"+findName+"该本书");
    }
}
