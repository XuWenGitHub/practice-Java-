package org.example;

import com.alibaba.fastjson.JSON;




public class Demo {
    public static void main(String[] args) {
        Person person = new Person((Integer)10, "徐文");
        String s = JSON.toJSONString(person);
        System.out.println(s);

        Person person1 = JSON.parseObject(s, Person.class);
        //Person person1 = JSON.parseObject(s, Person.class);
        System.out.println(person1);
    }
    static class Person{
        Integer val;
        String name;
        public Person(){}   //这个不能少，不然会报错
        public Person(int val, String name) {
            this.val = val;
            this.name = name;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "val=" + val +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
