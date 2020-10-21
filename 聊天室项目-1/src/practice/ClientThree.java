package practice;

/**
 * @PackgeName: practice
 * @ClassName: ClientThree
 * @Author: XuWen
 * Date: 2020/10/20 22:51
 * Introduce:
 */
public class ClientThree {
    public static void main(String[] args) {
        TCPClient client = new TCPClient("127.0.0.1",8888,"段扶摇");
        new Thread(client).start();
    }
}
