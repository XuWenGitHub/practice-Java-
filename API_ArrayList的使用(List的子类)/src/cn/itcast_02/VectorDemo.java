package cn.itcast_02;

import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        List<String> vect = new Vector<>();

        vect.add("徐文");
        vect.add("阿斯加德");

        ListIterator<String> li = vect.listIterator();
        while(li.hasNext()){
            System.out.println(li.next());
        }

        System.out.println("-------------");

        for(int i=0;i<vect.size();i++){
            System.out.println(vect.get(i));
        }

        System.out.println("-------------");

        Object[] array = vect.toArray();
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }

        System.out.println("-------------");

        for(String s:vect){
            System.out.println(s);
        }
    }
}
