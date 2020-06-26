package cn.itcast_02;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            method2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void method(){
        int a=10;
        int b=0;
        if(0==b){
            throw new ArithmeticException();
        }else {
            System.out.println(a/b);
        }
    }

    public static void method2() throws Exception {
        int a=10;
        int b=0;
        if(0==b){
            throw new Exception();
        }else {
            System.out.println(a/b);
        }
    }
}
