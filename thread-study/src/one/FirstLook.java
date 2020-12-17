package one;

public class FirstLook {
    public static void main(String[] args) {
        try {
            Thread.sleep(9999999999L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
