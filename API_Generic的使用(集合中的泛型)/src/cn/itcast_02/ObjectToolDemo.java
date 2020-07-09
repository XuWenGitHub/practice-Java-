package cn.itcast_02;

/*
* 泛型类的测试
* */
public class ObjectToolDemo {
    public static void main(String[] args) {
        ObjectTool<String> ot = new ObjectTool<String>();
        ot.setObj(new String("林青霞"));
        String s = ot.getObj();
        System.out.println("姓名是："+s);

        ObjectTool<Integer> ot2 = new ObjectTool<Integer>();
        ot2.setObj(new Integer(27));
        Integer i = ot2.getObj();
        System.out.println("年龄是："+i);

    }
}
