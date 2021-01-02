import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo {
    int num;  //1代表first先执行，2代表second执行，3代表third执行
    Lock lock ;
    Condition second ;
    Condition third ;
    Condition first;
    public Foo() {
        num = 1;
        lock = new ReentrantLock();
        third = lock.newCondition();
        second = lock.newCondition();
        first = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        while (num!=1){
            first.await();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        num = 2;
        second.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        while (num!=2){
            second.await();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        num = 3;
        third.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        while (num!=3){
            third.await();
        }

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        lock.unlock();
    }
}