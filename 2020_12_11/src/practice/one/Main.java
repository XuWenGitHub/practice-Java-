package practice.one;
class X{
    Y y = new Y();

    public X() {
        System.out.println("X");
    }
}
class Y{
    public Y() {
        System.out.println("Y");
    }
}
public class Main extends X {
    Y y = new Y();

    public Main() {
        System.out.println("Z");
    }

    public static void main(String[] args) {
        new Main();
    }

}
