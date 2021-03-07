package practice.two;


public class MyBlockingQueue<T> {

    //使用数组实现循环队列
    private final Object[] queue;

    //存放元素的索引
    private int putIndex;
    //取元素的索引
    private int tackIndex;
    //当前存放元素的数量
    private int size;

    public MyBlockingQueue(int len) {
        queue = new Object[len];
    }

    //存放元素
    public synchronized void put(T e) throws InterruptedException {
        while (size == queue.length) {
            this.wait();
        }
        queue[putIndex] = e;
        putIndex = (putIndex + 1) % queue.length;
        size++;
        this.notifyAll();
    }

    //取元素
    public synchronized T take() throws InterruptedException {
        while (size == 0) {
            this.wait();
        }
        T t = (T) queue[tackIndex];
        tackIndex = (tackIndex + 1) % queue.length;
        size--;
        this.notifyAll();
        return t;
    }

    //获取当前元素的数量
    public synchronized int size() {
        return size;
    }

    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(10);
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 1000; j++) {
                            queue.put(j);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (; ; ) {
                        try {
                            int i = queue.take();
                            System.out.println(Thread.currentThread().getName() + "：" + i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

}
