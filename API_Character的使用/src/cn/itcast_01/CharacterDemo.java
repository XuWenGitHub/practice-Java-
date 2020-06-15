package cn.itcast_01;

import java.sql.SQLOutput;

public class CharacterDemo {
    public static void main(String[] args) {
        System.out.println("isUpperCase:"+Character.isUpperCase('A'));
        System.out.println("---------");

        System.out.println("isLowerCase:"+Character.isLowerCase('a'));
        System.out.println("---------");

        System.out.println("isDigit:"+Character.isDigit('9'));
        System.out.println("---------");

        char c = Character.toUpperCase('a');
        System.out.println(c);
        System.out.println("---------");

        char c2 = Character.toLowerCase('k');
        System.out.println(c2);
        System.out.println("---------");
    }
}
