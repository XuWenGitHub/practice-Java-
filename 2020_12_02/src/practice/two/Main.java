package practice.two;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("0");
        } else {
            while (n != 0) {
                System.out.print((n % 10));
                n /= 10;
            }
        }
    }

}
