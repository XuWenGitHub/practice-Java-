package practice;

/**
 * @PackgeName: practice
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/20 22:24
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        TCPServer server = new TCPServer(8888);
        new Thread(server).start();
    }
}
