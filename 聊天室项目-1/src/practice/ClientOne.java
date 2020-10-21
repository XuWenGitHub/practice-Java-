package practice;

/**
 * @PackgeName: practice
 * @ClassName: ClientOne
 * @Author: XuWen
 * Date: 2020/10/20 22:40
 * Introduce:
 */
public class ClientOne {
    public static void main(String[] args) {
        TCPClient client = new TCPClient("127.0.0.1",8888,"徐文");
        new Thread(client).start();
    }
}
