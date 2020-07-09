package cn.itcast_03;

public class ObjectToolDemo {
    public static void main(String[] args) {
        ObjectTool<String> ot = new ObjectTool<String>();
        ot.show("hello");

        ObjectTool<Integer> ot2 = new ObjectTool<Integer>();
        ot2.show(27);

        ObjectTool<Boolean> ot3 = new ObjectTool<Boolean>();
        ot3.show(true);
    }
}
