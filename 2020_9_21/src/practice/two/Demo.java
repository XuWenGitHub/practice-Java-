package practice.two;
//脏读现象
class User{
    String name;
    double money;

    public synchronized void set(String name,double money){
        this.name = name;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.money = money;
        System.out.println(this.money);
    }
    //如果对上面写的方法进行加锁，对读的方法不进行加锁的话，会出现脏读现象
    /*
    例如：给玩家的用户增加钱，然后如果线程sleep，但是如果读的时候不加锁的话，
    当另一个线程去读取当前用户的钱的时候，就会还没有修改，这就是脏读现象
    根据不同的业务，不同的场景，来判断是否可以脏读
    如果可以脏读，那么效率当然都会快的多
     */
    public /*synchronized*/ double get(){
        return this.money;
    }


}
/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/21 10:26
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        User user = new User();
        new Thread(new Runnable() {
            @Override
            public void run() {
                user.set("徐文",100);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(user.name+"="+user.get());
            }
        }).start();


    }
}
