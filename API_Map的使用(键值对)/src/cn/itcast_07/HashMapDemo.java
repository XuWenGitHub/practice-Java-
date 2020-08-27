package cn.itcast_07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*
* 为了更符合要求：
*       这次的数据就看成是学生对象。
*
* 传智播客
*       bj  北京校区
*           jc  基础班
*                   林青霞     27
*                   风清扬     30
*           jy  就业班
*                   赵雅芝     28
*                   武鑫       29
*       sh  上海校区
*           jc  基础班
*                   郭美美     20
*                   犀利哥     22
*           jy  就业班
*                   罗玉凤     21
*                   马征       23
*       gz  广州校区
*           jc  基础班
*                   王力宏     30
*                   李金磊     32
*           jy  就业班
*                   浪浪       31
*                   柳岩       33
*       xa  西安校区
*           jc  基础班
*                   范冰冰     27
*                   刘毅       30
*           jy  就业班
*                   李冰冰     28
*                   张志豪     29
* */
public class HashMapDemo {
    public static void main(String[] args) {
        //创建大集合
        HashMap<String,HashMap<String, ArrayList<Student>>> czbkMap = new HashMap<String, HashMap<String, ArrayList<Student>>>();

        //北京校区数据
        HashMap<String,ArrayList<Student>> bjCzbkMap = new HashMap<String, ArrayList<Student>>();
        ArrayList<Student> array1 = new ArrayList<Student>();
        Student s1 = new Student("林青霞",27);
        Student s2 = new Student("风清扬",30);
        //Student ss3 = new Student("林青霞",27);  只有键与数据结构有关，值不存在哈希表的特点
        array1.add(s1);
        array1.add(s2);
        //array1.add(ss3);
        ArrayList<Student> array2 = new ArrayList<Student>();
        Student s3 = new Student("赵雅芝",28);
        Student s4 = new Student("武鑫",29);
        array2.add(s3);
        array2.add(s4);
        //bjCzbkMap.put("基础班",array1);
        bjCzbkMap.put("基础班",array1);
        bjCzbkMap.put("就业班",array2);
        czbkMap.put("北京校区",bjCzbkMap);

        //上海校区数据
        HashMap<String,ArrayList<Student>> shCzbkMap = new HashMap<String, ArrayList<Student>>();
        ArrayList<Student> array3 = new ArrayList<Student>();
        Student s5 = new Student("郭美美",20);
        Student s6 = new Student("犀利哥",22);
        array3.add(s5);
        array3.add(s6);
        ArrayList<Student> array4 = new ArrayList<Student>();
        Student s7 = new Student("罗玉凤",21);
        Student s8 = new Student("马征",23);
        array4.add(s7);
        array4.add(s8);
        czbkMap.put("上海校区",shCzbkMap);
        shCzbkMap.put("基础班",array3);
        shCzbkMap.put("就业班",array4);

        //广州校区数据
        HashMap<String,ArrayList<Student>> gzCzbkMap = new HashMap<String, ArrayList<Student>>();
        ArrayList<Student> array5 = new ArrayList<Student>();
        Student s9 = new Student("王力宏",30);
        Student s10= new Student("李金磊",32);
        array5.add(s9);
        array5.add(s10);
        ArrayList<Student> array6 = new ArrayList<Student>();
        Student s11 = new Student("浪浪",31);
        Student s12 = new Student("柳岩",33);
        array6.add(s11);
        array6.add(s12);
        czbkMap.put("广州校区",gzCzbkMap);
        gzCzbkMap.put("基础班",array5);
        gzCzbkMap.put("就业班",array6);

        //西安校区数据
        HashMap<String,ArrayList<Student>> xaCzbkMap = new HashMap<String, ArrayList<Student>>();
        ArrayList<Student> array7 = new ArrayList<Student>();
        Student s13 = new Student("范冰冰",27);
        Student s14= new Student("刘毅",30);
        array7.add(s13);
        array7.add(s14);
        ArrayList<Student> array8 = new ArrayList<Student>();
        Student s15 = new Student("李冰冰",28);
        Student s16 = new Student("张志豪",29);
        array8.add(s15);
        array8.add(s16);
        czbkMap.put("西安校区",xaCzbkMap);
        xaCzbkMap.put("基础班",array7);
        xaCzbkMap.put("就业班",array8);

        //遍历集合
        Set<String> czbkMapSet = czbkMap.keySet();
        for(String czbkMapKey:czbkMapSet){
            System.out.println(czbkMapKey+":");
            HashMap<String, ArrayList<Student>> czbkMapValue = czbkMap.get(czbkMapKey);
            Set<String> czbkMapValueSet = czbkMapValue.keySet();
            for(String czbkMapValueKey:czbkMapValueSet){
                System.out.println("\t"+czbkMapValueKey+":");
                ArrayList<Student> czbkMapValueValue = czbkMapValue.get(czbkMapValueKey);
                for(Student s:czbkMapValueValue){
                    System.out.println("\t\t"+s.getName()+"---"+s.getAge());
                }
            }
            System.out.println();
        }
    }
}
