package practice.one;

import java.util.*;

class Teacher {
    private int age;
    private int high;

    public Teacher(int age,int high){
        this.age = age;
        this.high = high;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", high=" + high +
                '}';
    }
}
/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/11 19:03
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
//        Set<Teacher> teachers = new TreeSet<>(new Comparator<Teacher>() {
//            @Override
//            public int compare(Teacher teacher, Teacher t1) {
//                return teacher.getAge()-t1.getAge();
//            }
//        });
//        Teacher t1 = new Teacher(3,1);
//        Teacher t2 = new Teacher(2),1;
//        Teacher t3 = new Teacher(1);]]
//        teachers.add(t1);
//        teachers.add(t2);
//        teachers.add(t3);
//
//        System.out.println(teachers);

        Teacher[] teachers2 = new Teacher[]{
                new Teacher(4,200),
                new Teacher(4,100),
                new Teacher(1,400),
                new Teacher(1,300),
        };

        bubbleSort(teachers2, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher teacher, Teacher t1) {
                int num = teacher.getAge()-t1.getAge();
                int num2 = num==0?(teacher.getHigh()-t1.getHigh()):(num);
                return num2;
            }
        });

        //bubbleSort(teachers2,new TeacherCompara());

        System.out.println(Arrays.toString(teachers2));
    }
    public static <T> void bubbleSort(T[] arr,Comparator<T> comparator){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(comparator.compare(arr[j],arr[j+1])>0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
