package practice.one;



public class InnerClass {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {

                while (true){
                    System.out.println("asda");
                }
            }
        };
        t.start();
        while (true){
            System.out.println("aaaaaaa");
        }
    }
}
