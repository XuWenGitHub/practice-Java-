package cn.itcast_02;

/*
* 匿名内部类使用多线程
* */
public class ThreadDemo {
    public static void main(String[] args) {
        //继承Thread类来实现多线程
        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<200;i++){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }.start();

        //实现Runnable接口实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<200;i++){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        },"徐文"){}.start();

        //更有难度的
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<200;i++){
                    System.out.println("hello"+":"+i);
                }
            }
        }){
            @Override
            public void run() {
                for(int i=0;i<200;i++){
                    System.out.println("world"+":"+i);
                }
            }
        }.start();
    }
}
