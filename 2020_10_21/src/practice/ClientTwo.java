package practice;

/**
 * @PackgeName: practice
 * @ClassName: ClientTwo
 * @Author: XuWen
 * Date: 2020/10/20 22:42
 * Introduce:
 */
public class ClientTwo {
    public static void main(String[] args) {
        TCPClient client =new TCPClient("127.0.0.1",8888,"代平飞");
        new Thread(client).start();
    }
}
