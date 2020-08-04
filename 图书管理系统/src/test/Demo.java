package test;

import book.Book;
import book.BookLinkedList;
import operation.AddOperation;
import operation.IOperation;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.io.*;
import java.util.Scanner;

/**
 * @PackgeName: test
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/4 15:28
 * Introduce:
 */
public class Demo {
    public static User login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入你的姓名：");
        String name = sc.next();
        System.out.println("请输入你的身份：1->管理员 0：普通用户");
        int n=sc.nextInt();

        if(n==1){
            return new AdminUser(name);
        }else {
            return new NormalUser(name);
        }
    }

    /**
     * 将文件里的读取到图书系统
     * @param path  文件的路径，必须要文件存在
     * @param bookLinkedList    图书系统
     */
    public static void readFile(String path,BookLinkedList bookLinkedList) throws IOException {
        //先判断path是否存在，如果存在再往下走，如果不存在，直接退出
        File file = new File(path);
        if(!file.exists()){
            return; //表示第一次进入系统，没有文件可以读取
        }
        Book newLinked = new Book("1","2",3,"1");
        Book newLinkedCur = newLinked;
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line=null;
        while((line=br.readLine())!=null){
            String[] strings = line.split(" ");
            boolean flag=strings[4].equals("true");
            Book book = new Book(strings[0],strings[1],Integer.parseInt(strings[2]),strings[3]);
            book.setBorrow(flag);
            newLinkedCur.setNext(book);
            newLinkedCur = newLinkedCur.getNext();
        }
        bookLinkedList.setTail(newLinkedCur);
        bookLinkedList.setHead(newLinked.getNext());
    }

    /**
     * 将图书系统里面的书存入文件里面
     * @param path  文件的路劲，如果文件不存在，自动创建
     * @param bookLinkedList    图书系统
     */
    public static void saveFile(String path,BookLinkedList bookLinkedList) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        if(bookLinkedList.isEmpty()){
            //表示图书系统里面没有书
            bw.close();
            return;
        }
        Book book = bookLinkedList.getHead();
        while(book!=null){
            bw.write(book.getName()+" "+book.getAuthor()+" "+book.getPrice()+" "+book.getType()+" "+book.isBorrow());
            bw.newLine();
            bw.flush();
            book=book.getNext();
        }
        bw.close();
    }
    public static void main(String[] args) throws IOException {
        BookLinkedList bookLinkedList = new BookLinkedList();   //图书系统
        readFile("book.txt",bookLinkedList);    //读取文件里面数据
        User user = login();
        while(true){
            int n=user.menu();
            if(n==0){
                break;
            }
            user.operations[n].work(bookLinkedList);
        }
        saveFile("book.txt",bookLinkedList);   //将文件里面的系统存入
    }
}
