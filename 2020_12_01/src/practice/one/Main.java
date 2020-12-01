package practice.one;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.getValue());
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        System.out.println(list);
        list.remove((Integer)1);
        System.out.println(list);
    }
    static class A{
        protected int value;

        public A(int value) {
            setValue(value);
        }
        public void setValue(int value){
            this.value = value;
        }
        public int getValue(){
            try {
                value++;
                return value;
            }catch (Exception e){
                System.out.println(e.toString());
            }finally {
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }
    static class B extends A{
        public B() {
            super(5);
            setValue(getValue()-3);
        }

        @Override
        public void setValue(int value) {
            super.setValue(2*value);
        }
    }
}
