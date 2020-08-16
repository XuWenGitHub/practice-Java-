package cn.itcast_06;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/*
* 键盘录入5个学生信息(姓名，语文成绩，数学成绩，英语成绩)，按照总分从高到低存入文本文件
*
* 分析：
*       A：创建学生类
*       B：创建集合对象
*           TreeSet<Student>
*       C:键盘录入学生信息存储到集合
*       D：遍历集合，把数据写到文本文件
* */
public class StudentDemo {
    public static void main(String[] args) throws IOException {
        //创建集合对象
        TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                int num1 = t1.getSum()-student.getSum();
                int num2 = num1==0?student.getChinese()-t1.getChinese() : num1;
                int num3 = num2==0?student.getMath()-t1.getMath() : num2;
                int num4 = num1==0?student.getEnglish()-t1.getEnglish() : num3;
                int num5 = num1==0?student.getName().compareTo(t1.getName()):num4;
                return num5;
            }
        });

        //键盘录入学生信息存储到集合
        for(int i=1;i<=5;i++){
            Scanner sc = new Scanner(System.in);
            System.out.println("请录入第"+i+"个的学生信息");
            System.out.println("姓名：");
            String name = sc.nextLine();

            System.out.println("语文成绩：");
            int chinese = sc.nextInt();
            System.out.println("数学成绩：");
            int math = sc.nextInt();
            System.out.println("英语成绩：");
            int english = sc.nextInt();

            //创建学生对象
            Student s = new Student();
            s.setName(name);
            s.setChinese(chinese);
            s.setMath(math);
            s.setEnglish(english);
            ts.add(s);
        }

        //遍历集合，把数据写到文本文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"));
        bw.write("学生信息如下：");
        bw.newLine();
        bw.flush();
        bw.write("姓名,语文成绩,数学成绩,英语成绩");
        bw.newLine();
        bw.flush();
        for(Student s:ts){
            StringBuilder sb = new StringBuilder();
            sb.append(s.getName()).append(",").append(s.getChinese()).append(",").append(s.getMath()).append(",").append(s.getEnglish());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        //释放资源
        bw.close();
        System.out.println("学生信息存储完毕");
    }
}
