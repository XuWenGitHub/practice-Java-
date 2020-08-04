package operation;

import book.Book;
import book.BookLinkedList;

import java.util.Scanner;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookLinkedList bookLinkedList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要归还的书名");
        String findName = sc.next();
        Book book = bookLinkedList.getHead();
        while (book!=null){
            if(book.getName().equals(findName)){
                //System.out.println("找到"+findName+"该本书");
                if(book.isBorrow()){
                    book.setBorrow(false);
                    System.out.println("《"+findName+"》归还成功");
                    return;
                }
                //System.out.println(book);
                System.out.println("该本书不是我们图书馆的");
                return;
            }
            book = book.getNext();
        }
        System.out.println("没有找到"+findName+"该本书");
    }
}
