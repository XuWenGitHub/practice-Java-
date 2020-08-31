package cn.itcast.test;

public class ToolDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person p = new Person();
        Tool t = new Tool();
        t.setProperty(p,"name","徐文");
        t.setProperty(p,"age",20);
        System.out.println(p);
    }
}

class Person{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
