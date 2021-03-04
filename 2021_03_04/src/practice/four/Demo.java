package practice.four;

public class Demo {
    String name;
    public static void main(String[] args) {
        Demo d = new Demo();
        d.name = "徐文";
        suibian(d);
        System.out.println(d.name);
    }
    public static void suibian(Demo d){
        System.out.println(d.name);
        d.name = "asda";
    }
}
