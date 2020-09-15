package practice.two;

import java.util.*;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/14 18:21
 * Introduce:
 */
public class Demo {
    static class Person{
        int id;
        String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id &&
                    Objects.equals(name, person.name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        Person p1 = new Person(2,"高博");
        Person p2 = new Person(1,"高博");
        Person p3 = new Person(3,"高博");
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
//        list.add(p3);
        System.out.println(list.contains(p2));
        System.out.println(list.indexOf(p2));
        System.out.println(list.lastIndexOf(p2));

        List<Person> list2 = list.subList(0,1);
        System.out.println(list);
        System.out.println(list2);

        System.out.println("-------------");
        System.out.println(list);
        list.sort(new Comparator<Person>(){

            @Override
            public int compare(Person person, Person t1) {
                int sum = person.id-t1.id;
                int sum2 = sum==0?person.name.compareTo(t1.name):sum;
                return sum2;
            }
        });

//        System.out.println(list);
//        System.out.println("-----------------");
//        System.out.println(list);
//        for(Person p:list){
//            if(p.id==1){
//                list.remove(p);
//            }
//        }
        System.out.println(list);

        System.out.println("------------------");
        //Iterator<Person> it = list.iterator();
//        Iterator<Person> it2 = list.iterator();
//
//        System.out.println(it.next());
//        System.out.println(it2.next());

//        while(it.hasNext()){
//            Person p = it.next();
//            list.remove(new Person(1,"高博"));
//            //System.out.println(list);
//        }
//        System.out.println(list);

        ListIterator<Person> lit = list.listIterator(list.size());
        while (lit.hasPrevious()) {
            System.out.println(lit.previous());
        }
        final var iterator = list.iterator();

        

    }
}
