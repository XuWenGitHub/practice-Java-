package cn.itcast_03;
/*
* 快捷键，手动定义private成员变量，点击上方Code，再点击里面的Generate
* 1.可以选择，自动给出无参，有参构造
* 2.可以选择，自动给出getXxx（输出成员变量），setXxx（给成员变量赋值）方法.
* */
public class Student {
    //成员变量
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
