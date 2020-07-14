package cn.itcast_03;

public class IntegerDemo {
    public static void main(String[] args) {
        // int --- String
        int number = 100;
        String s1 = String.valueOf(number);
        System.out.println("s1:"+s1);

        //String --- int
        String s2 = "100";
        int number2 = Integer.parseInt(s2);
        System.out.println("number2"+number);
    }
}
