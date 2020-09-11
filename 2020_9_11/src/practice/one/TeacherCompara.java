package practice.one;

import java.util.Comparator;

/**
 * @PackgeName: practice.one
 * @ClassName: TeacherCompara
 * @Author: XuWen
 * Date: 2020/9/11 22:08
 * Introduce:
 */
public class TeacherCompara implements Comparator<Teacher> {
    @Override
    public int compare(Teacher teacher, Teacher t1) {
        int num = teacher.getAge()-t1.getAge();
        int num2 = num==0? (teacher.getHigh()-t1.getHigh()):num;
        return num2;
    }
}
