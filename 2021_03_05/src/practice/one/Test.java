package practice.one;

public class Test {
    private int seat = 50;

    public synchronized int getSeat(){
        if(seat==0){
            return -1;
        }
        return seat--;
    }
    /**
     * 有一个教师，座位有50个，同时有三个老师安排同学的座位
     * 每个老师安排100个同学到这个教师。模拟使用多线程实现
     * 作座位编号是1-50，三个线程同时启动来安排同学
     * 直到座位安排满
     */
    public static void main(String[] args) {
        Test test = new Test();
        Thread[] teacher = new Thread[3];
        for (int i = 0; i < 3; i++) {
            final int n = i;
            teacher[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        int seat = test.getSeat();
                        if(seat!=-1){
                            System.out.println("第"+n+"个老师,分配第"+seat+"个座位");
                        }else {
                            break;
                        }
                    }
                }
            });
        }
        for (Thread t:teacher) {
            t.start();
        }

    }

}
